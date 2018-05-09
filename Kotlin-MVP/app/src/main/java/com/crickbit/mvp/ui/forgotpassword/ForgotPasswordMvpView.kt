package com.crickbit.mvp.ui.forgotpassword

import com.crickbit.mvp.ui.base.MvpView

interface ForgotPasswordMvpView : MvpView{

    fun openMainActivity()

    fun showError(message: String)

}