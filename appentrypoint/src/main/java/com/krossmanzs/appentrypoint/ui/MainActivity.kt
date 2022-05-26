package com.krossmanzs.appentrypoint.ui

import android.content.Intent
import android.content.pm.ShortcutManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.content.pm.ShortcutManagerCompat.FLAG_MATCH_PINNED
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
            if (ShortcutManagerCompat.isRequestPinShortcutSupported(this)) {
                val currPinned : List<ShortcutInfoCompat> = ShortcutManagerCompat.getShortcuts(this, FLAG_MATCH_PINNED);
                val currShortcutIdPinned : MutableList<String> = mutableListOf()

                for(currShortcut : ShortcutInfoCompat in currPinned) {
                    currShortcutIdPinned.add(currShortcut.id)
                }

                if(currShortcutIdPinned.contains(SHORTCUT_ID1)) {
                    Toast.makeText(this,"Sudah di pin!",Toast.LENGTH_SHORT).show()
                } else {
                    ShortcutManagerCompat.requestPinShortcut(this, shortcut, null);
                }
            }
            ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
        }

        btnParcelable.setOnClickListener {
            Intent(this, ParcelableActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}