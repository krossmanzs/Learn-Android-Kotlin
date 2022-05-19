package com.krossmanzs.appcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn2: Button = findViewById(R.id.btn2)

        btn2.setOnClickListener {
            finish()
        }
    }
}