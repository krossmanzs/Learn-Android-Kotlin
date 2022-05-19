package com.krossmanzs.appcomponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val btnStartService: Button = findViewById(R.id.btnStartService)
        val btnStopService: Button = findViewById(R.id.btnStopService)
        val btnBack: Button = findViewById(R.id.btnBack)
        val btnSendData: Button = findViewById(R.id.btnSendData)
        val tvInfoService: TextView = findViewById(R.id.tvInfoService)
        val etData: EditText = findViewById(R.id.etData)

        btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tvInfoService.text = "Service running"
            }
        }

        btnStopService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvInfoService.text = "Service stopped"
            }
        }

        btnSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}