package com.crickbit

import android.app.Application
import io.realm.Realm
import me.immathan.kotlinlogin.data.AppDataManager
import me.immathan.kotlinlogin.data.DataManager
import me.immathan.kotlinlogin.data.network.ApiHelper
import me.immathan.kotlinlogin.data.network.AppApiHelper
import me.immathan.kotlinlogin.data.network.RestAdapter
import me.immathan.kotlinlogin.data.preference.AppPreferenceHelper
import me.immathan.kotlinlogin.data.preference.PreferenceHelper
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MyApplication : Application() {


    lateinit var dataManager: DataManager
    lateinit var apiHelper: ApiHelper
    lateinit var restAdapter: RestAdapter
    lateinit var prefHelper: PreferenceHelper

    companion object {
        val FILE_NAME: String = "kotlin_sample"
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this)

        val calligraphyConfig = CalligraphyConfig.Builder()
                //.setDefaultFontPath("fonts/GothamRoundedMedium.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        CalligraphyConfig.initDefault(calligraphyConfig)
        restAdapter = RestAdapter()
        apiHelper = AppApiHelper(restAdapter)
        prefHelper = AppPreferenceHelper(applicationContext, MyApplication.FILE_NAME)
        dataManager = AppDataManager(apiHelper, prefHelper)
    }
}