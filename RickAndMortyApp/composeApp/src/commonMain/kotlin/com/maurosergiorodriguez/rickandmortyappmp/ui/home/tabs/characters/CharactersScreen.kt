package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

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
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    Box(modifier = Modifier.fillMaxSize().background(Color.Red))
}