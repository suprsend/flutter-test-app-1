package com.example.test_drive

import app.suprsend.SSApi
import app.suprsend.notification.SSNotificationHelper

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


internal class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        SSApi.getInstance().getUser().setAndroidFcmPush(token)
        // other providers method
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        SSNotificationHelper.showFCMNotification(this, remoteMessage)
        // other providers method
    }
}