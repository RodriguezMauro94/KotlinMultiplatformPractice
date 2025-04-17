package com.maurosergiorodriguez.rickandmortyappmp.domain

import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterOfTheDayModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDay: CharacterOfTheDayModel)
}