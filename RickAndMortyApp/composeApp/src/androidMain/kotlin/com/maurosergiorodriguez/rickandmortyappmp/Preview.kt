package com.maurosergiorodriguez.rickandmortyappmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters.CharacterOfTheDay

@Composable
@Preview(showBackground = true)
fun Preview() {
    CharacterOfTheDay(CharacterModel(
        id = 3,
        image = "",
        isAlive = true,
        name = "Morty"
    ))
}