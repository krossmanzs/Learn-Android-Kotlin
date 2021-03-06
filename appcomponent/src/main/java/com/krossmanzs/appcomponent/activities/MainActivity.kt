package com.krossmanzs.appcomponent.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.krossmanzs.appcomponent.R
import com.krossmanzs.appcomponent.service.ServiceActivity
import com.krossmanzs.appcomponent.broadcast_receiver.BroadcastReceiverActivity
import content_provider.GetContactActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btn1)
        val btnFinish: Button = findViewById(R.id.btnFinish)
        val btnGotoService: Button = findViewById(R.id.btnGotoService)
        val btnGotoBroadcastReceiver: Button = findViewById(R.id.btnGotoBroadcastReceiver)
        val btnGotoContentProvider: Button = findViewById(R.id.btnGotoContentProvider)

        btnGotoContentProvider.setOnClickListener {
            Intent(this, GetContactActivity::class.java).also {
                startActivity(it)
            }
        }

        btnGotoBroadcastReceiver.setOnClickListener {
            Intent(this, BroadcastReceiverActivity::class.java).also {
                startActivity(it)
            }
        }

        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        btnFinish.setOnClickListener {
            finish()
        }

        btnGotoService.setOnClickListener {
            Intent(this, ServiceActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "This is onStart()", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "This is onResume()", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "This is onDestroy()", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "This is onPause()", Toast.LENGTH_SHORT).show()
    }
}

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