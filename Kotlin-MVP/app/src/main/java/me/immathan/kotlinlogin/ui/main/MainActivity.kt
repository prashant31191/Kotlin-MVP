package me.immathan.kotlinlogin.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import com.crickbit.MyApplication
import com.crickbit.R
import kotlinx.android.synthetic.main.activity_logout.*
import me.immathan.kotlinlogin.ui.base.BaseActivity
import me.immathan.kotlinlogin.ui.login.LoginActivity

class MainActivity : BaseActivity(), MainMvpView {

    private lateinit var mainPresenter: MainPresenter<MainMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        mainPresenter = MainPresenter((application as MyApplication).dataManager)
        mainPresenter.onAttach(this)
        name.text = mainPresenter.getName()
        logout.setOnClickListener {
            mainPresenter.logout()
        }

    }

    override fun onStart() {
        super.onStart()

        tick.post({
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val startRadius = 0
                val cx = tick.width / 2
                val cy = tick.height / 2
                val endRadius = Math.hypot(tick.width.toDouble(), tick.height.toDouble()).toInt()
                val anim = ViewAnimationUtils.createCircularReveal(tick, cx, cy, startRadius.toFloat(), endRadius.toFloat())
                anim.duration = 1000
                tick.visibility = View.VISIBLE
                anim.start()
            }
        })
    }

    override fun gotoLoginActivity() {
        val intent = LoginActivity.getNewIntent(applicationContext)
        startActivity(intent)
        finish()
    }

}