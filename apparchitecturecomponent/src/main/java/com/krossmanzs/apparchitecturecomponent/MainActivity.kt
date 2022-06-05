package com.krossmanzs.apparchitecturecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.krossmanzs.apparchitecturecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // learn viewModel and LiveData in kotlin
    // https://www.youtube.com/watch?v=whAVI1vTOko

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.count.observe(this) {
            binding.tvCount.text = "$it"
        }

        binding.btnCount.setOnClickListener {
            viewModel.updateCount()
        }
    }
}