package com.krossmanzs.apparchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krossmanzs.apparchitecture.databinding.ActivityMainBinding
import com.krossmanzs.apparchitecture.mvi.ui.main.view.MviActivity
import com.krossmanzs.apparchitecture.mvp.MvpActivity
import com.krossmanzs.apparchitecture.mvvm.view.MvvmActivity

// Learn it from here
// https://youtu.be/UTvR-dU0SXk

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMvvm.setOnClickListener {
            Intent(this, MvvmActivity::class.java).also {
                startActivity(it)
            }
        }
        
        binding.btnMvp.setOnClickListener { 
            Intent(this, MvpActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnMvi.setOnClickListener {
            Intent(this, MviActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}