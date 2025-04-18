package com.maurosergiorodriguez.rickandmortyappmp.domain

import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterOfTheDayModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDay: CharacterOfTheDayModel)
}