package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paging.compose.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    val state by episodesViewModel.state.collectAsState()
    val episode = state.episodes.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize().background(Color.Green))
}