package com.krossmanzs.appentrypoint.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.krossmanzs.appentrypoint.R
import com.krossmanzs.appentrypoint.model.Car

class ParcelableActivity : AppCompatActivity() {
    lateinit var btnSubmit : Button
    lateinit var etMerk: EditText
    lateinit var etPlat: EditText
    lateinit var etTahun: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        btnSubmit = findViewById(R.id.btnSubmit)
        etMerk = findViewById(R.id.etMerk)
        etPlat = findViewById(R.id.etPlat)
        etTahun = findViewById(R.id.etTahun)

        setListener()
    }

    private fun setListener() {
        btnSubmit.setOnClickListener {
            val merk = etMerk.text.toString()
            val plat = etPlat.text.toString()
            val tahun = etTahun.text.toString().toInt()

            val car = Car(
                merk,
                tahun,
                plat
            )

            Intent(this, CarDetailActivity::class.java).also {
                it.putExtra(CarDetailActivity.EXTRA_CAR, car)
                startActivity(it)
            }

            etMerk.text.clear()
            etPlat.text.clear()
            etTahun.text.clear()
        }
    }
}