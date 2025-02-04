package com.maurosergiorodriguez.rickandmortyappmp.domain

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}