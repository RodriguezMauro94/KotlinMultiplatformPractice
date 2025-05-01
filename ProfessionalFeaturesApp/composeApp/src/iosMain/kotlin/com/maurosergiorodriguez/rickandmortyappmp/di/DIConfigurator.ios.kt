package com.maurosergiorodriguez.rickandmortyappmp.di

import com.maurosergiorodriguez.rickandmortyappmp.data.database.RickAndMortyDatabase
import com.maurosergiorodriguez.rickandmortyappmp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickAndMortyDatabase> {
            getDatabase()
        }
    }
}