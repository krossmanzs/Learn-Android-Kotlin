package com.krossmanzs.apparchitecture.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.krossmanzs.apparchitecture.databinding.ActivityMvvmBinding
import com.krossmanzs.apparchitecture.mvvm.viewmodel.CityViewModel

class MvvmActivity : AppCompatActivity() {

    // Note 'by viewModels'
    // jika activity killed dan respawn lagi maka kita tidak perlu
    // meng instansiasinya lagi
    private val model: CityViewModel by viewModels()
    private lateinit var binding : ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this) { city ->
            binding.imgCity.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.tvCity.text = city.name
            binding.tvPopulation.text = "${city.population}"
        }
    }
}