package com.krossmanzs.appdesignpattern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krossmanzs.appdesignpattern.builder.BuilderActivity
import com.krossmanzs.appdesignpattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBuilder.setOnClickListener {
            Intent(this, BuilderActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}