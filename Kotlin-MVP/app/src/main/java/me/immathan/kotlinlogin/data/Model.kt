package me.immathan.kotlinlogin.data


data class LoginResponse(var id: Int,
                         var success: Boolean,
                         var message: String,
                         var token: String,
                         var name: String)
