# WhatsApp Auto Reply (Android starter)

A small Kotlin/Android Studio starter project. It listens for WhatsApp notifications
and replies only when the notification exposes an inline-reply action and the
offline phrase matcher recognizes the message.

## Open and build
1. Install Android Studio (current stable) with Android SDK 35.
2. Open this folder as an existing project.
3. Let Gradle sync.
4. Build > Build Bundle(s) / APK(s) > Build APK(s).
5. Install the APK on your Android phone.

## Enable
1. Open the app.
2. Tap "Open Notification Access Settings".
3. Enable WhatsApp Auto Reply.
4. Keep WhatsApp notifications enabled.

## Important limitations
- This is a basic offline phrase matcher, not a generative AI model.
- It only replies when WhatsApp provides an inline-reply action in the notification.
- Notification formats and reply actions vary by WhatsApp/Android version and device.
- Test with a second account first. Automatic replies can send unintended messages.
- Do not use it for OTPs, financial messages, sensitive conversations, or emergencies.
- This project is source code; it is not a prebuilt APK.
