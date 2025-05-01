package com.maurosergiorodriguez.professionalfeaturesapp.di

import com.maurosergiorodriguez.professionalfeaturesapp.domain.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacter)
}