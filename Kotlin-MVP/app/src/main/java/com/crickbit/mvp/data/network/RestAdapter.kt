package com.crickbit.mvp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAdapter {

    companion object {
        private val API_BASE = "https://us-central1-friendly-chat-4a901.cloudfunctions.net/"
    }

    val apiHelper: ApiHelper

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        apiHelper = retrofit.create(ApiHelper::class.java)
    }
}
