package com.krossmanzs.appnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.krossmanzs.appnavigation.fragment.FragmentActivity
import com.krossmanzs.appnavigation.navgraph.NavGraphActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNavGraph : Button = findViewById(R.id.btnNavGraph)
        val btnFragment : Button = findViewById(R.id.btnFragment)

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