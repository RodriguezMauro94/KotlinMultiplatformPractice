package com.maurosergiorodriguez.rickandmortyappmp

import androidx.compose.ui.window.ComposeUIViewController
import com.maurosergiorodriguez.rickandmortyappmp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = {
    initKoin()
}) { App() }