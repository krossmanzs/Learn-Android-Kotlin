package com.krossmanzs.apparchitecture.mvp.presenter

import com.krossmanzs.apparchitecture.mvp.model.User
import com.krossmanzs.apparchitecture.mvp.view.ILoginView

class LoginPresenter(private var iLoginView: ILoginView) : ILoginPresenter {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        when (user.isDataValid()) {
            0 -> iLoginView.onLoginFail("Email must not be null!")
            1 -> iLoginView.onLoginFail("Wrong email address")
            2 -> iLoginView.onLoginFail("Password must be greater than 6")
            else -> iLoginView.onLoginSuccess("Login Success")
        }
    }
}