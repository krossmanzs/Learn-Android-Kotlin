package com.krossmanzs.appentrypoint.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.krossmanzs.appentrypoint.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val SHORTCUT_ID1 = "shortcut_id1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnParcelable : Button = findViewById(R.id.btnParcelable)
        val btnRemoveShortcut : Button = findViewById(R.id.btnRemoveShortcut)
        val btnAddShortcut : Button = findViewById(R.id.btnAddShortcut)

        val shortcut = ShortcutInfoCompat.Builder(this, SHORTCUT_ID1)
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_baseline_open_in_browser_24))
            .setIntent(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/")))
            .build()

        btnRemoveShortcut.setOnClickListener {
            ShortcutManagerCompat.removeDynamicShortcuts(this, listOf(SHORTCUT_ID1))
        }

        btnAddShortcut.setOnClickListener {
            ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
        }

        btnParcelable.setOnClickListener {
            Intent(this, ParcelableActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}