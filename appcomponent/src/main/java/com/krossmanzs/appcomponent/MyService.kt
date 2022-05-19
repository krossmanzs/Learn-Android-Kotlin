package com.krossmanzs.appcomponent

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import java.util.concurrent.Executors

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