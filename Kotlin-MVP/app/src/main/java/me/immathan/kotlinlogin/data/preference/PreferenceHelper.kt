package me.immathan.kotlinlogin.data.preference

interface PreferenceHelper {

    fun getToken(): String?

    fun saveToken(token: String)

    fun saveName(name: String)

    fun getName(): String?

}