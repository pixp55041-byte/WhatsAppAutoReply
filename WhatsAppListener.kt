package com.example.whatsappautoreply

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class WhatsAppListener : NotificationListenerService() {

    private val handledKeys = LinkedHashSet<String>()

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        if (sbn.packageName != "com.whatsapp" &&
            sbn.packageName != "com.whatsapp.w4b") return

        val extras = sbn.notification.extras
        val message = extras.getCharSequence("android.text")?.toString()?.trim()
            ?: return

        // Avoid responding to empty, bundled-summary, or likely non-message notifications.
        if (message.isBlank() || message == " " ||
            message.contains("new messages", ignoreCase = true)) return

        val key = "${sbn.key}:$message"
        synchronized(handledKeys) {
            if (handledKeys.contains(key)) return
        }

        val reply = FreeAI.generate(message)
        if (reply.isBlank()) return

        val replyAction = sbn.notification.actions
            ?.firstOrNull { action -> action.remoteInputs?.isNotEmpty() == true }
            ?: return

        val remoteInputs = replyAction.remoteInputs ?: return
        val input = remoteInputs.firstOrNull() ?: return

        try {
            val fillInIntent = Intent()
            val results = Bundle().apply {
                putCharSequence(input.resultKey, reply)
            }
            RemoteInput.addResultsToIntent(remoteInputs, fillInIntent, results)
            replyAction.actionIntent.send(this, 0, fillInIntent)

            synchronized(handledKeys) {
                handledKeys.add(key)
                while (handledKeys.size > 200) {
                    val iterator = handledKeys.iterator()
                    iterator.next()
                    iterator.remove()
                }
            }
        } catch (_: Exception) {
            // The notification may not expose a usable inline-reply action.
        }
    }
}
