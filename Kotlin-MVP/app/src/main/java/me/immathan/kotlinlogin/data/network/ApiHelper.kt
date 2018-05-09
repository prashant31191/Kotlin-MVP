package me.immathan.kotlinlogin.data.network

import me.immathan.kotlinlogin.data.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("authenticate")
    fun doLogin(@Query("mobileno") mobileNo: String,@Query("password") password: String) : Call<LoginResponse>

}
