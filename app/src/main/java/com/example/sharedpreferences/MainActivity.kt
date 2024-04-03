package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        val aboutUser = sharedPreferencesHelper.getUser()
        findViewById<TextView>(R.id.user_first_name).text =
            "Ism: ${aboutUser?.firstName ?: "Uknown"}"
        findViewById<TextView>(R.id.user_last_name).text =
            "Familiya: ${aboutUser?.lastName ?: "Uknown"}"
        findViewById<TextView>(R.id.user_age).text = "Yosh: ${aboutUser?.age ?: "Uknown"}"

        findViewById<Button>(R.id.log_out_button).setOnClickListener {
            startActivity(logOut())
        }

    }

    private fun logOut(): Intent {
        sharedPreferencesHelper.clear()
        val intent = Intent(this, SplashPageActivity::class.java)
        finish()
        return intent
    }
}