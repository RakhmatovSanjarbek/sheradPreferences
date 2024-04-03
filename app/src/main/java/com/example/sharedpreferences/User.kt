package com.example.sharedpreferences

data class User(
    val firstName: String,
    val lastName: String,
    val age: String,
    var isLogin: Boolean = false
)
