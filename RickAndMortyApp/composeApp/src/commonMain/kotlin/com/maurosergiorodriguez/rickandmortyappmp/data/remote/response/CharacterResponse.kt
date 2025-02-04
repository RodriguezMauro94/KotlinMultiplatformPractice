package com.maurosergiorodriguez.rickandmortyappmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    @SerialName("id") val id: String,
    val status: String,
    val image: String
)