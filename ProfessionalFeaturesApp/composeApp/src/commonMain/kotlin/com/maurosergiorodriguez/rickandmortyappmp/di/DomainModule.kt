package com.maurosergiorodriguez.rickandmortyappmp.di

import com.maurosergiorodriguez.rickandmortyappmp.domain.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacter)
}