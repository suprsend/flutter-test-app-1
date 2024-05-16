package com.example.test_drive

import android.app.Application

import app.suprsend.SSApi

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class MainApplication: Application() {

    override fun onCreate() {

        SSApi.init(this, "SS_KEY", "SS_SECRET")
        super.onCreate()

    }
}