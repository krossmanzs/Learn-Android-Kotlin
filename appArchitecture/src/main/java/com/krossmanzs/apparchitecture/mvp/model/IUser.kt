package com.krossmanzs.apparchitecture.mvp.model

interface IUser {
    val email: String
    val password: String
    fun isDataValid(): Int
}