package com.crickbit.mvp.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.crickbit.MyApplication
import com.crickbit.R
import com.crickbit.mvp.ui.base.BaseActivity
import com.crickbit.mvp.ui.forgotpassword.ForgotPasswordActivity
import com.crickbit.mvp.ui.main.MainActivity
import com.crickbit.mvp.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(), LoginMvpView {

    private lateinit var loginPresenter: LoginPresenter<LoginMvpView>

    companion object {
        fun getNewIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter((application as MyApplication).dataManager)

        loginPresenter.onAttach(this)
        loginPresenter.isLoggedIn()

        login.setOnClickListener {
            etPassword.hideKeyboard()
            loginPresenter.doLogin(etEmail.text.toString(), etPassword.text.toString())
        }

        forgotPassword.setOnClickListener {
            openForgotPasswordActivity();
        }

        etPassword.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE) {
                etPassword.hideKeyboard()
                loginPresenter.doLogin(etEmail.text.toString(), etPassword.text.toString())
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

    override fun openForgotPasswordActivity() {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

}
