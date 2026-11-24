package com.example.whatsappautoreply

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class WhatsAppListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (sbn.packageName != "com.whatsapp" &&
            sbn.packageName != "com.whatsapp.w4b") return

        val message = sbn.notification.extras
            .getCharSequence("android.text")?.toString()?.trim()
            ?: return

        if (message.isBlank()) return

        val reply = FreeAI.generate(message)
        if (reply.isBlank()) return

        val action = sbn.notification.actions
            ?.firstOrNull { it.remoteInputs?.isNotEmpty() == true }
            ?: return

        val remoteInputs = action.remoteInputs ?: return

        try {
            val fillInIntent = Intent()
            val results = Bundle()
            results.putCharSequence(remoteInputs[0].resultKey, reply)

            RemoteInput.addResultsToIntent(
                remoteInputs,
                fillInIntent,
                results
            )

            action.actionIntent.send(this, 0, fillInIntent)
        } catch (_: Exception) {
        }
    }
}
