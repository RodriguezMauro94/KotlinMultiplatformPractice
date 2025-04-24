package com.maurosergiorodriguez.rickandmortyappmp.domain.model

import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity

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
            selectedDay =  selectedDay
        )
    }
}
