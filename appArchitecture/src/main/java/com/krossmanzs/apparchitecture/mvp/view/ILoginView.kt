package com.krossmanzs.apparchitecture.mvp.view

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginFail(message: String)
}