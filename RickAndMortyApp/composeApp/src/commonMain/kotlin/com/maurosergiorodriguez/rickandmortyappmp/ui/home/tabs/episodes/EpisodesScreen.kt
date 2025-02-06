package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
}