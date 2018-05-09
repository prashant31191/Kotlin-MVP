package com.crickbit.mvp.data


data class LoginResponse(var id: Int,
                         var success: Boolean,
                         var message: String,
                         var token: String,
                         var name: String)
