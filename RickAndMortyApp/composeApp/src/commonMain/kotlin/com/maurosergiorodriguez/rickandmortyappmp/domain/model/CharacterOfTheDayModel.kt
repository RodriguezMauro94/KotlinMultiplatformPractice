package com.maurosergiorodriguez.rickandmortyappmp.domain.model

import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return  CharacterOfTheDayEntity(
            id = characterModel.id,
            isAlive = characterModel.isAlive,
            image = characterModel.image,
            name = characterModel.name,
            species = characterModel.species,
            selectedDay =  selectedDay,
            origin = characterModel.origin,
            gender = characterModel.gender,
            episodes = Json.encodeToString<List<String>>(characterModel.episodes)
        )
    }
}
