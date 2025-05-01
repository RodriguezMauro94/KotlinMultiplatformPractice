package com.maurosergiorodriguez.professionalfeaturesapp.di

import com.maurosergiorodriguez.professionalfeaturesapp.data.database.RickAndMortyDatabase
import com.maurosergiorodriguez.professionalfeaturesapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickAndMortyDatabase> {
            getDatabase()
        }
    }
}