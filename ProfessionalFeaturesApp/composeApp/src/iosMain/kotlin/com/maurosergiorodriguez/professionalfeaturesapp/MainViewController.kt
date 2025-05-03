package com.maurosergiorodriguez.professionalfeaturesapp

import androidx.compose.ui.window.ComposeUIViewController
import com.maurosergiorodriguez.professionalfeaturesapp.di.initKoin
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.crashlytics.crashlytics
import dev.gitlive.firebase.initialize

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }

fun initialize() {
    if (!isDebug()) {
        Firebase.initialize()
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(true)
    }
}