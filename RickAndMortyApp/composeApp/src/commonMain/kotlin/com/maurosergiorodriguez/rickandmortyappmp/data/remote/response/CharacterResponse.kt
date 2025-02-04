package com.maurosergiorodriguez.rickandmortyappmp.data.remote.response

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: String,
    val status: String,
    val image: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id =id,
            isAlive = status.lowercase() == "Alive",
            image = image
        )
    }
}