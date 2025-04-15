package com.maurosergiorodriguez.rickandmortyappmp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDAO {
    @Query("SELECT * FROM characterOfTheDay")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?


}