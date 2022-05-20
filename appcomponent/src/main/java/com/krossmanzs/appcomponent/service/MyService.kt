package com.krossmanzs.appcomponent.service

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.krossmanzs.appcomponent.R
import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.Executors
import kotlin.math.roundToInt

class MyService : Service() {
    val TAG = "MyService"

    init {
        Log.d(TAG, "Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")

        runBlocking {
            val scope = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
            CoroutineScope(scope).launch {
                dataString?.let {
                    Log.d(TAG, dataString)
                }

                repeat(3) { // WARNING! Endless loop
                    Log.d(TAG,"data")
                }
            }.start()
        }

        return START_STICKY

        // FOR MORE INFORMATION
        // https://stackoverflow.com/questions/9093271/start-sticky-and-start-not-sticky
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service is being killed...")
    }
}

class MyServiceTimer : Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    private val timer = Timer()

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val time = intent.getDoubleExtra(TIME_EXTRA, 0.0)
        timer.scheduleAtFixedRate(TimeTask(time), 0,1000)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    private inner class TimeTask(private var time: Double) : TimerTask() {
        override fun run() {
            val intent = Intent(TIMER_UPDATED)
            time++
            intent.putExtra(TIME_EXTRA, time)
            sendBroadcast(intent)
        }
    }

    companion object {
        const val TIMER_UPDATED = "timerUpdated"
        const val TIME_EXTRA = "timeExtra"
    }
}

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