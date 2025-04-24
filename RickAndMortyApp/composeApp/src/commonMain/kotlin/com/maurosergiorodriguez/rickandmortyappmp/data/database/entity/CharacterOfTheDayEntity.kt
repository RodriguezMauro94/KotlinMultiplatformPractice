package com.maurosergiorodriguez.rickandmortyappmp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterOfTheDayModel

@Entity("characterOfTheDay")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val species: String,
    val selectedDay: String
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id,
                isAlive,
                image,
                name,
                species
            ),
            selectedDay = selectedDay
        )
    }
}
