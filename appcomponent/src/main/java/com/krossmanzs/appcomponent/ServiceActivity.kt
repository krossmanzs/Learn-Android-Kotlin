package com.krossmanzs.appcomponent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class ServiceActivity : AppCompatActivity() {
    private var timerStarted = false
    private lateinit var serviceTimerIntent: Intent
    private lateinit var tvTimer: TextView
    private lateinit var btnStartTimer: Button
    private lateinit var btnResetTimer: Button
    private var time = 0.0

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

        btnStartTimer= findViewById(R.id.btnStartTimer)
        btnResetTimer= findViewById(R.id.btnResetTimer)
        tvTimer = findViewById(R.id.tvTimer)

        btnStartTimer.setOnClickListener { startStopTimer() }
        btnResetTimer.setOnClickListener { resetTimer() }

        serviceTimerIntent = Intent(applicationContext, MyServiceTimer::class.java)
        registerReceiver(updateTime, IntentFilter(MyServiceTimer.TIMER_UPDATED))
    }

    private fun resetTimer() {
        stopTimer()
        time = 0.0
        tvTimer.text = getTimeStringFromDouble(time)
    }

    private fun startStopTimer() {
        if(timerStarted) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun stopTimer() {
        stopService(serviceTimerIntent)
        btnStartTimer.text = "Start"
        timerStarted = false
    }

    private fun startTimer() {
        serviceTimerIntent.putExtra(MyServiceTimer.TIME_EXTRA, time)
        startService(serviceTimerIntent)
        btnStartTimer.text = "Stop"
        timerStarted = true
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            time = intent.getDoubleExtra(MyServiceTimer.TIME_EXTRA,0.0)
            tvTimer.text = getTimeStringFromDouble(time)
        }
    }

    private fun getTimeStringFromDouble(time: Double): String {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d",hours, minutes, seconds)
    }
}