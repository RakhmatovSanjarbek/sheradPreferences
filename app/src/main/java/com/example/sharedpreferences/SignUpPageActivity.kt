package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SignUpPageActivity : AppCompatActivity() {


    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    private lateinit var userFirstName: EditText
    private lateinit var userLastname: EditText
    private lateinit var userAge: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_page)

        sharedPreferencesHelper = SharedPreferencesHelper(this)

        userFirstName = findViewById(R.id.edit_user_first_name)
        userLastname = findViewById(R.id.edit_user_last_name)
        userAge = findViewById(R.id.edit_user_age)

        val signUpButton = findViewById<MaterialButton>(R.id.sign_up_button)

        signUpButton.setOnClickListener {
            startActivity(saveAndSignUp())
        }

    }

    private fun saveAndSignUp(): Intent {
        val userFirstName = userFirstName.text.toString()
        val userLastName = userLastname.text.toString()
        val userAge = userAge.text.toString()

        val user = User(userFirstName, userLastName, userAge, true)

        sharedPreferencesHelper.saveUser(user)

        val intent=Intent(this, MainActivity::class.java)
        finish()
        return intent

    }


}