package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun CharactersScreen() {
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        if (state.characterOfTheDay != null) {
            state.characterOfTheDay?.let {
                Text(it.image)
            }
        }
    }
}

@Composable
fun CharacterOfTheDay(title: String) {
    Text(title)
}