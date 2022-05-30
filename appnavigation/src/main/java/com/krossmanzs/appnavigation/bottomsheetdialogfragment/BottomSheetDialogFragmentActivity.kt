package com.krossmanzs.appnavigation.bottomsheetdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krossmanzs.appnavigation.databinding.ActivityBottomSheetDialogFragmentBinding

class BottomSheetDialogFragmentActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomSheetDialogFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetDialogFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileImage.setOnClickListener {
            BottomSheetDialogFragment()
                .show(supportFragmentManager, BottomSheetDialogFragment.TAG)
        }
    }
}