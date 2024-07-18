package framework

import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val TAG = "PushNotificationsKit"
object PushNotificationsKit {
    fun initNotificationListener(scope: CoroutineScope) {
        NotifierManager.addListener(
            object : NotifierManager.Listener {
                override fun onNewToken(token: String) {
                    scope.launch {

                    }
                }

                override fun onNotificationClicked(data: PayloadData) {
                    Napier.d(" Notification clicked $data", tag = TAG)
                    onNotificationClickedImpl(data)
                }

                override fun onPayloadData(data: PayloadData) {
                    Napier.d(" Payload data $data", tag = TAG)
                    onPayloadDataImpl(data)
                }

                override fun onPushNotification(title: String?, body: String?) {
                    val notifier = NotifierManager.getLocalNotifier()
                    Napier.d { "Push notification $title" }
                    notifier.notify(title ?: "", body ?: "")

                }
            }
        )

    }
}

expect fun onNotificationClickedImpl(data: Map<String, *>)
expect fun onPayloadDataImpl(data: Map<String, *>)


