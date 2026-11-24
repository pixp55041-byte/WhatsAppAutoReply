
package com.example.whatsappautoreply

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.content.ComponentName
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var info: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 60, 40, 40)
        }

        val title = TextView(this).apply {
            text = "Free WhatsApp Auto Reply"
            textSize = 24f
        }

        info = TextView(this).apply {
            textSize = 18f
        }

        val button = Button(this).apply {
            text = "Enable Notification Access"
            setOnClickListener {
                startActivity(
                    Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                )
            }
        }

        layout.addView(title)
        layout.addView(info)
        layout.addView(button)
        setContentView(layout)
    }

    override fun onResume() {
        super.onResume()

        val component = ComponentName(this, WhatsAppListener::class.java)
        val enabled = Settings.Secure.getString(
            contentResolver,
            "enabled_notification_listeners"
        )?.contains(component.flattenToString()) == true

        info.text = if (enabled) {
            "Notification Access Enabled"
        } else {
            "Notification Access Disabled"
        }
    }
}
