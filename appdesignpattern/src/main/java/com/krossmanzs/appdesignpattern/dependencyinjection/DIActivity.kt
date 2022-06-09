package com.krossmanzs.appdesignpattern.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krossmanzs.appdesignpattern.databinding.ActivityDiactivityBinding

class DIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weapon = Weapon("Lazarus Spear", "Sword of Hazard")

        val lightKnight = LightKnight(weapon)
        val darkKnight = DarkKnight(weapon)

        binding.btnClick.setOnClickListener {
            val getReport = "${lightKnight.setEquip()} and ${darkKnight.setEquip()}"
            binding.tvReport.text = getReport
        }
    }
}