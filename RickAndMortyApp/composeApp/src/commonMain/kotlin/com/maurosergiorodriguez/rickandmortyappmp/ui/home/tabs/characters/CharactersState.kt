package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel

data class CharactersState (
    val characterOfTheDay: CharacterModel? = null
)