package framework

import com.mmk.kmpnotifier.notification.NotifierManager

actual fun onNotificationClickedImpl(data: Map<String, *>) {

}

actual fun onPayloadDataImpl(data: Map<String, *>) {

    // Extract data
    val aps = data["aps"] as? Map<*, *>
    val alert = aps?.get("alert") as? Map<*, *>
    val title = alert?.get("title") as? String
    val body = alert?.get("body") as? String
    if (title != null && body != null) {
        println("Title: $title")
        println("Body: $body")

        // Notify using NotifierManager
        NotifierManager.getLocalNotifier().notify(title, body)
    } else {
        println("Failed to extract title and body from notification payload")
    }
}
