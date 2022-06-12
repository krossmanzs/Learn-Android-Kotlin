package com.krossmanzs.apparchitecture.mvvm.model

import com.krossmanzs.apparchitecture.R

class CityDataProvider {
    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bandar Lampung", R.drawable.bandar_lampung, 1_023_400))
        cities.add(City("Bandung", R.drawable.bandung, 35_423))
        cities.add(City("Jakarta", R.drawable.jakarta, 4_353_423))
        cities.add(City("Jayapura", R.drawable.jayapura, 2_334_353))
        cities.add(City("Jogyakarta", R.drawable.jogja, 56_543_433))
        cities.add(City("Pringsewu", R.drawable.pringsewu, 8_756_345))
    }

    fun getCities() = cities
}