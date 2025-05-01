package com.maurosergiorodriguez.professionalfeaturesapp.domain

import androidx.paging.PagingData
import com.maurosergiorodriguez.professionalfeaturesapp.data.database.entity.CharacterOfTheDayEntity
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterOfTheDayModel
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDay: CharacterOfTheDayModel)
    suspend fun getEpisodesForCharacter(episodes: List<String>): List<EpisodeModel>
}