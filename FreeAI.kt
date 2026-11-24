package com.example.whatsappautoreply

import java.util.Locale

object FreeAI {
    fun generate(message: String): String {
        val msg = message.lowercase(Locale.ROOT).trim()

        return when {
            msg.contains("hello") || msg == "hi" || msg == "hey" ->
                "Hey! How are you? 😊"
            msg.contains("how are you") ->
                "I'm fine! How are you? 😊"
            msg.contains("thank") ->
                "You're welcome! 😊"
            msg.contains("good morning") ->
                "Good morning! Have a great day 🌞"
            msg.contains("good night") ->
                "Good night! Take care 🌙"
            msg.contains("kaise ho") || msg.contains("कैसे हो") ->
                "Main bilkul theek hoon 😊 Aap kaise ho?"
            msg.contains("kya kar rahe") ->
                "Abhi thoda busy hoon, aap batao 😊"
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
