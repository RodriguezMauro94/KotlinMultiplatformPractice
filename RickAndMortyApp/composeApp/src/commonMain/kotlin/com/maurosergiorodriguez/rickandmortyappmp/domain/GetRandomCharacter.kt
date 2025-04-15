package com.maurosergiorodriguez.rickandmortyappmp.domain

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacter(
    private val repository: Repository
) {
    suspend operator fun invoke(): CharacterModel {
        /*
        if (getCurrentDayOfTheYear() == characterDatabase.now) {
            // Fetch db object
        } else {
            val randomId = (1 .. 826).random()
            return repository.getSingleCharacter(randomId.toString())
        }
        */

        repository.getCharacterDB()

        val randomId = (1 .. 826).random()
        return repository.getSingleCharacter(randomId.toString())
    }

    private fun getCurrentDayOfTheYear(): Int {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return localTime.dayOfYear
    }
}