package com.example.whatsappautoreply

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 60, 40, 40)
        }
        val title = TextView(this).apply {
            text = "WhatsApp Auto Reply"
            textSize = 26f
        }
        val info = TextView(this).apply {
            text = "\nFree offline reply assistant\n\n" +
                "1. Allow WhatsApp notifications.\n" +
                "2. Enable notification access below.\n" +
                "3. Keep this app enabled to process notifications.\n\n" +
                "This starter uses simple phrase matching, not a cloud AI model."
            textSize = 16f
        }
        val button = Button(this).apply {
            text = "Open Notification Access Settings"
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            }
        }
        layout.addView(title)
        layout.addView(info)
        layout.addView(button)
        setContentView(layout)
    }
}
