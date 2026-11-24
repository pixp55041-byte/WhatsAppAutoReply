package com.example.whatsappautoreply

import java.util.Locale

object FreeAI {
    fun generate(message: String): String {
        val msg = message.lowercase(Locale.ROOT).trim()

        return when {
            Regex(".*\\b(hello|hi|hey)\\b.*").matches(msg) ->
                "Hey! How are you? 😊"
            msg.contains("how are you") ->
                "I'm doing well, thanks! How are you? 😊"
            msg.contains("thank") ->
                "You're welcome! 😊"
            msg.contains("good morning") ->
                "Good morning! Have a great day 🌞"
            msg.contains("good night") ->
                "Good night! Take care 🌙"
            msg.contains("kaise ho") || msg.contains("कैसे हो") ->
                "Main theek hoon 😊 Aap kaise ho?"
            msg.contains("kya kar rahe") ->
                "Abhi thoda busy hoon. Aap batao 😊"
            msg.contains("namaste") || msg.contains("नमस्ते") ->
                "Namaste! Kaise hain aap? 🙏"
            msg.contains("kem cho") || msg.contains("કેમ છો") ->
                "Majama! Tame kem cho? 😊"
            msg.contains("su karo cho") || msg.contains("શું કરો છો") ->
                "Bas thodu kaam chhe. Tame kaho 😊"
            else -> ""
        }
    }
}
