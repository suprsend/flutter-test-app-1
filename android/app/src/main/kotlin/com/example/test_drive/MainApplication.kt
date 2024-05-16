package com.example.test_drive

import android.app.Application

import app.suprsend.SSApi

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class MainApplication: Application() {

    override fun onCreate() {

        SSApi.init(this, "kfWdrPL1nFqs7OUihiBn", "From1HA1ZiSXs3ofBHXh", "https://collector-staging.suprsend.workers.dev/")
        super.onCreate()

        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            val fcmToken = task.result
            SSApi.getInstance().getUser().setAndroidFcmPush(fcmToken)
        })
    }
}