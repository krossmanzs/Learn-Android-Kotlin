package com.krossmanzs.appcomponent.broadcast_receiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.krossmanzs.appcomponent.R

class BroadcastReceiverActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    private lateinit var receiverAirplaneChanged : AirplaneModeChangedReceiver
    private lateinit var receiverConnectivity : ConnectivityReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        receiverAirplaneChanged = AirplaneModeChangedReceiver()
        receiverConnectivity = ConnectivityReceiver()

        // registering Connectivity Receiver
        // CONNECTIVITY_ACTION is deprecated
        // see https://stackoverflow.com/questions/36421930/connectivitymanager-connectivity-action-deprecated

        // im using it only for my learn process, not in real project :)
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(receiverConnectivity, it)
        }

        // registering Airplane Mode Changed Receiver
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiverAirplaneChanged, it)
        }
    }

    // Complementary method pairs to register-unregister receiver:
    // onCreate - onDestroy
    // onResume - onPause
    // onStart  - onStop

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiverAirplaneChanged)
        unregisterReceiver(receiverConnectivity)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        Log.d("TEST_AJA", "dari onNetworkConnectionChanged $isConnected")
        showNetworkMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    private fun showNetworkMessage(isConnected: Boolean) {
        if(!isConnected) {
            Toast.makeText(this,"You are offline",Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"You are online",Toast.LENGTH_SHORT).show()
        }
    }
}