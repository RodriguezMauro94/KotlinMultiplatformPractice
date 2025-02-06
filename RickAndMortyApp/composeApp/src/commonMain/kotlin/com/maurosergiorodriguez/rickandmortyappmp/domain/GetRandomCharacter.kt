package com.maurosergiorodriguez.rickandmortyappmp.domain

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel

class GetRandomCharacter(
    val repository: Repository
) {
    suspend operator fun invoke(): CharacterModel {
        val randomId = (1 .. 826).random()
        return repository.getSingleCharacter(randomId.toString())
    }
}