package com.example.whatsappautoreply

import java.util.Locale

object FreeAI {
    fun generate(message: String): String {
        val msg = message.lowercase(Locale.ROOT).trim()

        return when {
            msg.contains("hello") || msg == "hi" || msg == "hey" ->
                "Hello! Hu thodi vaar ma tamne reply karish. 😊"
            msg.contains("kem cho") || msg.contains("કેમ છો") ->
                "Majama! Tame kem cho? 😊"
            msg.contains("thank") ->
                "Aapnu swagat chhe! 😊"
            msg.contains("good morning") ->
                "Good morning! 🌞"
            msg.contains("good night") ->
                "Good night! 🌙"
            else ->
                "Hu haal busy chhu. Thodi vaar ma jawab aapish. 😊"
        }
    }
}
