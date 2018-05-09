package com.crickbit.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.ncapdevi.fragnav.FragNavController

import com.crickbit.R
import com.crickbit.demo.animlist.AnimListActivity
import kotlinx.android.synthetic.main.activity_home.*
import me.immathan.kotlinlogin.ui.login.LoginActivity


//Better convention to properly name the indices what they are in your app
const val INDEX_RECENTS = FragNavController.TAB1
const val INDEX_FAVORITES = FragNavController.TAB2
const val INDEX_NEARBY = FragNavController.TAB3
const val INDEX_FRIENDS = FragNavController.TAB4
const val INDEX_FOOD = FragNavController.TAB5
const val INDEX_RECENTS2 = FragNavController.TAB6
const val INDEX_FAVORITES2 = FragNavController.TAB7
const val INDEX_NEARBY2 = FragNavController.TAB8
const val INDEX_FRIENDS2 = FragNavController.TAB9
const val INDEX_FOOD2 = FragNavController.TAB10
const val INDEX_RECENTS3 = FragNavController.TAB11
const val INDEX_FAVORITES3 = FragNavController.TAB12

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.crickbit.R.layout.activity_home)

        //val btnBottomTabs = findViewById<View>(R.id.btnBottomTabs) as Button
        btnBottomTabs.setOnClickListener { startActivity(Intent(this@MainActivity, BottomTabsActivity::class.java)) }

        // val btnNavDrawer = findViewById<View>(R.id.btnNavDrawer) as Button
        btnNavDrawer.setOnClickListener { startActivity(Intent(this@MainActivity, NavDrawerActivity::class.java)) }

        //val btnNavAnimList = findViewById<View>(R.id.btnNavAnimList) as Button
        btnNavAnimList.setOnClickListener { startActivity(Intent(this@MainActivity, AnimListActivity::class.java)) }


        //val btnNavAnimList = findViewById<View>(R.id.btnNavAnimList) as Button
        btnNavLogin.setOnClickListener { startActivity(Intent(this@MainActivity, LoginActivity::class.java)) }
    }
}