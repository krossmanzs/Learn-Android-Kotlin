package com.krossmanzs.appcomponent.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log

// Learning how to check internet connection with Broadcast Receiver
// see https://medium.com/@dilipsuthar97/listen-to-internet-connection-using-broadcastreceiver-in-android-kotlin-6b527426a6f2

class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("TEST_AJA", "dari receiver")
        if(connectivityReceiverListener != null) {
            //  !! converts any value to a non-null type and throws an exception if the value is null
            connectivityReceiverListener!!.onNetworkConnectionChanged(isConnectedOrConnecting(context!!))
        }
    }

    private fun isConnectedOrConnecting(context: Context): Boolean {
        val connectionManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        // as = unsafe cast operator.

        // DEPRECATED, see https://stackoverflow.com/questions/53532406/activenetworkinfo-type-is-deprecated-in-api-level-28
        // val networkInfo = connectionManager.activeNetworkInfo

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectionManager.activeNetwork ?: return false
            val networkInterface = connectionManager.getNetworkCapabilities(networkCapabilities) ?: return false
            return when {
                networkInterface.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                networkInterface.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                networkInterface.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectionManager.run {
                return connectionManager.activeNetworkInfo?.run {
                    when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                } ?: false
            }
        }
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }

    companion object {
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }
}