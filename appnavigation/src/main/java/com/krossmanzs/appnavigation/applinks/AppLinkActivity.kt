package com.krossmanzs.appnavigation.applinks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krossmanzs.appnavigation.R

class AppLinkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_link)

        val uri = intent.data

        if (uri != null) {
            val path = uri.toString()
            Toast.makeText(this, "Path = $path", Toast.LENGTH_SHORT).show()
        }

    }
}