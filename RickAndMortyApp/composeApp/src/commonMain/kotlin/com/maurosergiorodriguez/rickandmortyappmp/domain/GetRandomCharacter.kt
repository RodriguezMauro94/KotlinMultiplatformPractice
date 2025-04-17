package com.maurosergiorodriguez.rickandmortyappmp.domain

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterOfTheDayModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacter(
    private val repository: Repository
) {
    suspend operator fun invoke(): CharacterModel {
        val characterOfTheDayModel: CharacterOfTheDayModel? = repository.getCharacterDB()
        val currentDay = getCurrentDayOfTheYear()
        return if (characterOfTheDayModel != null && characterOfTheDayModel.selectedDay == currentDay) {
            characterOfTheDayModel.characterModel
        } else {
            val newCharacter = generateRandomCharacter()
            repository.saveCharacterDB(
                CharacterOfTheDayModel(
                    characterModel = newCharacter,
                    selectedDay = currentDay
                )
            )
            return newCharacter
        }
    }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val randomId = (1 .. 826).random()
        return repository.getSingleCharacter(randomId.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}