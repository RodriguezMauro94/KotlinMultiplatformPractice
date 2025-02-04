package com.maurosergiorodriguez.rickandmortyappmp.data

import com.maurosergiorodriguez.rickandmortyappmp.data.remote.ApiService
import com.maurosergiorodriguez.rickandmortyappmp.domain.Repository
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel

class RepositoryImpl(
    private val apiService: ApiService
): Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return apiService.getSingleCharacter(id).toDomain()
    }
}