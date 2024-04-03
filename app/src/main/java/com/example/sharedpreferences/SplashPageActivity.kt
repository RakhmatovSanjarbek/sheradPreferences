package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashPageActivity : AppCompatActivity() {

    private val onClickButton by lazy { findViewById<Button>(R.id.splash_page_button) }

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_page)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        onClickButton.setOnClickListener {
            startActivity(nextPage())
        }
    }

    private fun nextPage(): Intent {
        val islogin = sharedPreferencesHelper.getUser()
        if (islogin?.isLogin == true) {
            val intent=Intent(this, MainActivity::class.java)
            finish()
            return intent
        } else {
            val intent=Intent(this, SignUpPageActivity::class.java)
            finish()
            return intent
        }
    }
}