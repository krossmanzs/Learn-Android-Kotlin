package com.krossmanzs.appcomponent.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // ?: artinya ketika valuenya null maka kita return
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirplaneModeEnabled) {
            Toast.makeText(context,"Airplane mode is enabled",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context,"Airplane mode is disabled",Toast.LENGTH_SHORT).show()
        }
    }
}