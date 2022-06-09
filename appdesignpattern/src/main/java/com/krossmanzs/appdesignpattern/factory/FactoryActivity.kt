package com.krossmanzs.appdesignpattern.factory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krossmanzs.appdesignpattern.builder.PopUp
import com.krossmanzs.appdesignpattern.databinding.ActivityFactoryBinding

class FactoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFactoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFactoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rgPlan.setOnCheckedChangeListener { _, _ ->
            binding.btnPick.isEnabled = true
        }

        binding.btnPick.setOnClickListener {
            when (binding.rgPlan.checkedRadioButtonId) {
                binding.rbStandard.id -> {
                    val plan = HostingFactory.getHostingFrom(HostingType.STANDARD).getService()
                    PopUp.Builder(this)
                        .setMessage(plan)
                        .build()
                        .show()
                }
                binding.rbPremium.id -> {
                    val plan = HostingFactory.getHostingFrom(HostingType.PREMIUM).getService()
                    PopUp.Builder(this)
                        .setMessage(plan)
                        .build()
                        .show()
                }
            }
        }
    }
}