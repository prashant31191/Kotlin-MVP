package com.crickbit.mvp.ui.forgotpassword

import com.crickbit.mvp.ui.base.MvpPresenter
import com.crickbit.mvp.ui.base.MvpView

interface ForgotPasswordMvpPresenter<V: MvpView> : MvpPresenter<V> {

    fun doForgot(mobile : String)

    fun isLoggedIn()

}