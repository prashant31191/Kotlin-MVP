package com.crickbit.mvp.ui.forgotpassword

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.crickbit.MyApplication
import com.crickbit.R
import com.crickbit.mvp.ui.base.BaseActivity
import com.crickbit.mvp.ui.main.MainActivity
import com.crickbit.mvp.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_forgot_password.*


class ForgotPasswordActivity : BaseActivity(), ForgotPasswordMvpView {

    private lateinit var loginPresenter: ForgotPasswordPresenter<ForgotPasswordMvpView>

    companion object {
        fun getNewIntent(context: Context) = Intent(context,ForgotPasswordActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        loginPresenter = ForgotPasswordPresenter((application as MyApplication).dataManager)

        loginPresenter.onAttach(this)
        loginPresenter.isLoggedIn()

        submit.setOnClickListener {
            etEmail.hideKeyboard()
            loginPresenter.doForgot(etEmail.text.toString())
        }

        login.setOnClickListener{
            onBackPressed()
        }

        etEmail.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if ( id == EditorInfo.IME_ACTION_DONE) {
                etEmail.hideKeyboard()
                loginPresenter.doForgot(etEmail.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun showError(message: String) {
        onError(message)
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
