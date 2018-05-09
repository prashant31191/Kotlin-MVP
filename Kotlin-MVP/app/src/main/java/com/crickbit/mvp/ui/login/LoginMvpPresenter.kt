package com.crickbit.mvp.ui.login

import com.crickbit.mvp.ui.base.MvpPresenter
import com.crickbit.mvp.ui.base.MvpView

interface LoginMvpPresenter<V: MvpView> : MvpPresenter<V> {

    fun doLogin(mobile : String, password: String)

    fun isLoggedIn()

}