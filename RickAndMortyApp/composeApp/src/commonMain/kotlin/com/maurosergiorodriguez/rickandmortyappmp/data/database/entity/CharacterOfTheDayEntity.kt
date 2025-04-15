package com.maurosergiorodriguez.rickandmortyappmp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val selectedDate: String
)
