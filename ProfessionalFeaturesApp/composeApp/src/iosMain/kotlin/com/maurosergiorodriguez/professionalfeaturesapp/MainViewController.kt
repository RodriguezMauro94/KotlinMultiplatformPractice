package com.maurosergiorodriguez.professionalfeaturesapp

import androidx.compose.ui.window.ComposeUIViewController
import com.maurosergiorodriguez.professionalfeaturesapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }