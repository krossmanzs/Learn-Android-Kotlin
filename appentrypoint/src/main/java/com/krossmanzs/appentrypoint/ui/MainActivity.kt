package com.krossmanzs.appentrypoint.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.krossmanzs.appentrypoint.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnParcelable : Button = findViewById(R.id.btnParcelable)

        btnParcelable.setOnClickListener {
            Intent(this, ParcelableActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}