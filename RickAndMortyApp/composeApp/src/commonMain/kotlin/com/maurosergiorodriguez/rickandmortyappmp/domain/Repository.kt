package com.maurosergiorodriguez.rickandmortyappmp.domain

import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
}