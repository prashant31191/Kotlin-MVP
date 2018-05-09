package com.crickbit.mvp.ui.login

import com.crickbit.mvp.ui.base.MvpView

interface LoginMvpView : MvpView{

    fun openMainActivity()
    fun openForgotPasswordActivity()

    fun showError(message: String)

}