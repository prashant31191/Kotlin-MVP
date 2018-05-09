package me.immathan.kotlinlogin.ui.main

import me.immathan.kotlinlogin.data.DataManager
import me.immathan.kotlinlogin.ui.base.BasePresenter
import me.immathan.kotlinlogin.utils.PreferenceKeys

class MainPresenter<T : MainMvpView>(private val dataManager: DataManager) : BasePresenter<T>(), MainMvpPresenter<T> {

    override fun getName(): String? {
        return dataManager.getPrefString(PreferenceKeys().pref_name)
    }

    override fun logout() {
        dataManager.savePrefString(PreferenceKeys().pref_token,"")
        mvpView?.gotoLoginActivity()
    }

}