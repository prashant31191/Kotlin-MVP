package com.crickbit.mvp.data.network

import com.crickbit.mvp.data.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("authenticate")
    fun doLogin(@Query("mobileno") mobileNo: String,@Query("password") password: String) : Call<LoginResponse>

    @GET("forgot_password")
    fun doForgot(@Query("mobileno") mobileNo: String) : Call<LoginResponse>

}
