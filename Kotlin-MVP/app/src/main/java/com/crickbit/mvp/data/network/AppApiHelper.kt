
package com.crickbit.mvp.data.network

import com.crickbit.mvp.data.LoginResponse
import retrofit2.Call

class AppApiHelper(private var mRestAdapter: RestAdapter) : ApiHelper {

    override fun doLogin(mobileNo: String, password: String): Call<LoginResponse> {
        return mRestAdapter.apiHelper.doLogin(mobileNo, password)
    }
    override fun doForgot(mobileNo: String): Call<LoginResponse> {
        return mRestAdapter.apiHelper.doForgot(mobileNo)
    }

}
