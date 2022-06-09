package com.krossmanzs.appdesignpattern.builder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krossmanzs.appdesignpattern.databinding.ActivityBuilderBinding

class BuilderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuilderBinding
    private var popUp: PopUp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuilderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            if (popUp == null) {
                popUp = PopUp.Builder(this)
                    .setMessage("Halo teman teman")
                    .build()
            } else {
                Toast.makeText(this, "popup sudah dibuat", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnShow.setOnClickListener {
            if (popUp != null) {
                popUp?.show()
            } else {
                Toast.makeText(this, "popup belum dibuat", Toast.LENGTH_SHORT).show()
            }
        }
    }
}