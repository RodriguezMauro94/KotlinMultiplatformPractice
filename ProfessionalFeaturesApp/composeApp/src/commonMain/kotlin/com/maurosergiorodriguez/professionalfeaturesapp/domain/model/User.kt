package com.maurosergiorodriguez.professionalfeaturesapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val title: String,
    val company: String
)