package me.immathan.kotlinlogin.ui.login

import me.immathan.kotlinlogin.ui.base.MvpView

interface LoginMvpView : MvpView{

    fun openMainActivity()

    fun showError(message: String)

}