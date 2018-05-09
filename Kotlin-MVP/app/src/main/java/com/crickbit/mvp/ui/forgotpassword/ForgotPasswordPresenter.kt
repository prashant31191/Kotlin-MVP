package com.crickbit.mvp.ui.forgotpassword

import android.text.TextUtils
import com.google.gson.Gson
import com.crickbit.mvp.data.DataManager
import com.crickbit.mvp.data.LoginResponse
import com.crickbit.mvp.ui.base.BasePresenter
import com.crickbit.mvp.utils.Logger
import com.crickbit.mvp.utils.PreferenceKeys
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordPresenter<V : ForgotPasswordMvpView>(private val dataManager: DataManager) : BasePresenter<V>(), ForgotPasswordMvpPresenter<V> {

    companion object {
        private val TAG: String = ForgotPasswordPresenter::class.java.simpleName
    }

    override fun doForgot(mobile: String) {
        if (TextUtils.isEmpty(mobile)) {
            mvpView?.onError("Enter valid mobile number")
            return
        }



        mvpView?.showProgress()
        Logger.d(TAG, "Sending login request")


        dataManager.doForgot(mobile).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Logger.d(TAG, "===onFailure==")
                Logger.e(TAG, "Login failure")
                mvpView?.hideProgress()
                mvpView?.onError(t?.localizedMessage!!)
            }



            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Logger.d(TAG, "===onResponse==")
                mvpView?.hideProgress()
                if (response != null && response.isSuccessful) {
                    mvpView?.openMainActivity()

                    dataManager.savePrefString(PreferenceKeys().pref_token, response.body()!!.token)
                    dataManager.savePrefString(PreferenceKeys().pref_name, response.body()!!.name)

                    Logger.d(TAG, "Login success")
                } else {
                    if(response?.errorBody() != null) {
                        Logger.e(TAG, "Login not success")
                        val gson = Gson()
                        val loginResponse = gson.fromJson(response.errorBody()!!.string(), LoginResponse::class.java)
                        mvpView?.onError(loginResponse.message)
                    }
                }
            }
        })



       /* dataManager.doLogin(mobile, password).enqueue(object : Callback<LoginResponse?> {
            override fun onFailure(call: Call<LoginResponse?>?, t: Throwable?) {
                Logger.e(TAG, "Login failure")
                mvpView?.hideProgress()
                mvpView?.onError(t?.localizedMessage!!)
            }


          override fun onResponse(call: Call<LoginResponse?>?, response: Response<LoginResponse?>?) {
                mvpView?.hideProgress()
                if (response != null && response.isSuccessful) {
                    mvpView?.openMainActivity()
                    dataManager.saveToken(response.body()!!.token)
                    dataManager.saveName(response.body()!!.name)
                    Logger.d(TAG, "Login success")
                } else {
                    if(response?.errorBody() != null) {
                        Logger.e(TAG, "Login not success")
                        val gson = Gson()
                        val loginResponse = gson.fromJson(response.errorBody()!!.string(), LoginResponse::class.java)
                        mvpView?.onError(loginResponse.message)
                    }
                }
            }
        })*/
    }

    override fun isLoggedIn() {
        if(!dataManager.getPrefString(PreferenceKeys().pref_token)?.isEmpty()!!) {
            mvpView?.openMainActivity()
        }
    }
}