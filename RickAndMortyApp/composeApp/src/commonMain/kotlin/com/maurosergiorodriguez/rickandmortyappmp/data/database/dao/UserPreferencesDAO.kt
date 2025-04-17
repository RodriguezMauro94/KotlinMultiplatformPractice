package com.maurosergiorodriguez.rickandmortyappmp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDAO {
    @Query("SELECT * FROM characterOfTheDay")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?

    @Insert(entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(characterOfTheDayEntity: CharacterOfTheDayEntity)
}