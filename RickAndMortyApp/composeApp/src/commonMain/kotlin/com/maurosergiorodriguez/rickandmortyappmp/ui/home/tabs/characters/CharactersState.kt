package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState (
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)