package com.krossmanzs.apparchitecture.mvp.presenter

interface ILoginPresenter {
    fun onLogin(email: String, password: String)
}