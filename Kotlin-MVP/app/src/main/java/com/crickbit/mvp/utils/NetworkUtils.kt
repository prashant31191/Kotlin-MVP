package com.crickbit.mvp.utils

import android.content.Context

class NetworkUtils {

    companion object {

        /**
         * Extension method to get connectivityManager for Context.
         */

        fun isNetworkConnected(con : Context): Boolean {
            return con.connectivityManager?.activeNetworkInfo != null
        }
    }

}