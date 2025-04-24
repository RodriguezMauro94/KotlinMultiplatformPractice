package com.maurosergiorodriguez.rickandmortyappmp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.maurosergiorodriguez.rickandmortyappmp.data.database.dao.UserPreferencesDAO
import com.maurosergiorodriguez.rickandmortyappmp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

@Database(entities = [CharacterOfTheDayEntity::class], version = 3)
@ConstructedBy(RickAndMortyCTor::class)
abstract class RickAndMortyDatabase: RoomDatabase() {
    abstract fun getPreferencesDao(): UserPreferencesDAO
}

//this line will be marked with an error by the AS, but it works fine
expect object RickAndMortyCTor: RoomDatabaseConstructor<RickAndMortyDatabase>
