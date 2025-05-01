package com.maurosergiorodriguez.professionalfeaturesapp.ui.home.tabs.characters

import androidx.paging.PagingData
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState (
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>> = emptyFlow()
)