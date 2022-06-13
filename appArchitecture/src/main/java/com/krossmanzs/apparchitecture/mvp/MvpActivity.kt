package com.krossmanzs.apparchitecture.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krossmanzs.apparchitecture.databinding.ActivityMvpBinding
import com.krossmanzs.apparchitecture.mvp.presenter.ILoginPresenter
import com.krossmanzs.apparchitecture.mvp.presenter.LoginPresenter
import com.krossmanzs.apparchitecture.mvp.view.ILoginView

class MvpActivity : AppCompatActivity(), ILoginView {

    private lateinit var binding : ActivityMvpBinding
    private lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // init
        loginPresenter = LoginPresenter(this)

        // event
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            loginPresenter.onLogin(email, password)
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFail(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}