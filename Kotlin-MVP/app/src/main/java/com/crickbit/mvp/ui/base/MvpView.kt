package com.crickbit.mvp.ui.base

import android.support.annotation.StringRes

interface MvpView {

    fun showProgress()

    fun hideProgress()

    fun onError(@StringRes resId : Int)

    fun onError(error : String)

    fun showMessage(message : String)

    fun isNetworkConnected() : Boolean

}