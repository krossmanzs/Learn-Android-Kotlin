package com.krossmanzs.appentrypoint.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.krossmanzs.appentrypoint.R
import com.krossmanzs.appentrypoint.model.Car

class CarDetailActivity : AppCompatActivity() {

    private lateinit var tvMerk: TextView
    private lateinit var tvPlat: TextView
    private lateinit var tvTahun: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        initVar()

        // mendapatkan parcelable
        val car : Car = intent.getParcelableExtra<Car>(EXTRA_CAR) as Car

        val merk = car.merk.toString()
        val tahun = car.tahun.toInt()
        val plat = car.plat.toString()

        tvMerk.text = "Merk: $merk"
        tvTahun.text = "Tahun: $tahun"
        tvPlat.text = "Plat: $plat"
    }

    private fun initVar() {
        tvMerk = findViewById(R.id.tvMerk)
        tvPlat = findViewById(R.id.tvPlat)
        tvTahun = findViewById(R.id.tvTahun)
    }

    companion object {
        const val EXTRA_CAR = "extra_car"
    }
}