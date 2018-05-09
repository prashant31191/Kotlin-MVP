package com.crickbit.mvp.ui.main

import com.crickbit.mvp.data.DataManager
import com.crickbit.mvp.ui.base.BasePresenter
import com.crickbit.mvp.utils.PreferenceKeys

class MainPresenter<T : MainMvpView>(private val dataManager: DataManager) : BasePresenter<T>(), MainMvpPresenter<T> {

    override fun getName(): String? {
        return dataManager.getPrefString(PreferenceKeys().pref_name)
    }

    override fun logout() {
        dataManager.savePrefString(PreferenceKeys().pref_token,"")
        mvpView?.gotoLoginActivity()
    }

}