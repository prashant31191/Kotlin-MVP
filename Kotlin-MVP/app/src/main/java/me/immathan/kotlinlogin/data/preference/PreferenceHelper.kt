package me.immathan.kotlinlogin.data.preference

interface PreferenceHelper {

    fun savePrefString(key: String?, value: String?)
    fun getPrefString(key: String?): String?

}