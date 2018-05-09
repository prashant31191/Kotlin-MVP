package me.immathan.kotlinlogin.data.preference

import android.content.Context
import android.content.SharedPreferences

class AppPreferenceHelper(context: Context, fileName: String, private var sharedPreferences: SharedPreferences? = null) : PreferenceHelper {

    companion object {
        val TOKEN_KEY = "token_id"
        val NAME = "name"
    }

    init {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    override fun savePrefString(key: String?, value: String?) {
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun getPrefString(key: String?): String? = sharedPreferences?.getString(key, "")




}