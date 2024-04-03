package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferencesHelper(context: Context) {

    private val mysharedPreferences: SharedPreferences =
        context.getSharedPreferences("users", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: User) {
        val editor = mysharedPreferences.edit()
        val json = gson.toJson(user)
        editor.putString("user", json)
        editor.apply()
    }

    fun getUser(): User? {
        val json = mysharedPreferences.getString("user", null)
        return gson.fromJson(json, User::class.java)
    }

    fun clear() {
        val editor = mysharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}