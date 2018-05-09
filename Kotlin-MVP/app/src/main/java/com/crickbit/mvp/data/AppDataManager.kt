package com.crickbit.mvp.data

import com.crickbit.mvp.data.network.ApiHelper
import com.crickbit.mvp.data.preference.PreferenceHelper
import retrofit2.Call

class AppDataManager (private val apiHelper: ApiHelper, private val preferenceHelper: PreferenceHelper): DataManager {


    override fun getPrefString(key: String?): String?
    {
        return preferenceHelper.getPrefString(key)
    }

    override fun savePrefString(key: String?, value: String?) {
        preferenceHelper.savePrefString(key,value)
    }



    override fun doLogin(mobileNo: String, password: String): Call<LoginResponse> {
        return apiHelper.doLogin(mobileNo, password)
    }

    override fun doForgot(mobileNo: String): Call<LoginResponse> {
        return apiHelper.doForgot(mobileNo)
    }
/*
    override fun getToken(): String? {
        return preferenceHelper.getToken()
    }

    override fun saveToken(token: String) {
        preferenceHelper.saveToken(token)
    }

    override fun getName(): String? {
        return preferenceHelper.getName()
    }

    override fun saveName(name: String) {
        preferenceHelper.saveName(name)
    }*/

}