
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
            setPadding(35, 60, 35, 35)
        }

        val title = TextView(this).apply {
            text = "WhatsApp Auto Reply"
            textSize = 26f
        }

        val info = TextView(this).apply {
            text = "\nFree Automatic Reply Assistant\n\n" +
                "Enable notification access to start."
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
}
