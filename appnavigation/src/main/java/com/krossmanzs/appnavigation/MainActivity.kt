package com.krossmanzs.appnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.krossmanzs.appnavigation.bottomsheetdialogfragment.BottomSheetDialogFragmentActivity
import com.krossmanzs.appnavigation.dialogfragment.DownloadConfirmationDialogFragment
import com.krossmanzs.appnavigation.fragment.FragmentActivity
import com.krossmanzs.appnavigation.navgraph.NavGraphActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavGraph : Button = findViewById(R.id.btnNavGraph)
        val btnFragment : Button = findViewById(R.id.btnFragment)
        val btnDialogFragment : Button = findViewById(R.id.btnDialogFragment)
        val btnBottomSheetDialogFragment : Button = findViewById(R.id.btnBottomSheetDialogFragment)

        btnBottomSheetDialogFragment.setOnClickListener {
            Intent(this, BottomSheetDialogFragmentActivity::class.java).also {
                startActivity(it)
            }
        }

        btnDialogFragment.setOnClickListener {
            DownloadConfirmationDialogFragment().show(
                supportFragmentManager, DownloadConfirmationDialogFragment.TAG
            )
        }

        btnNavGraph.setOnClickListener {
            Intent(this, NavGraphActivity::class.java).also {
                startActivity(it)
            }
        }

        btnFragment.setOnClickListener {
            Intent(this, FragmentActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}