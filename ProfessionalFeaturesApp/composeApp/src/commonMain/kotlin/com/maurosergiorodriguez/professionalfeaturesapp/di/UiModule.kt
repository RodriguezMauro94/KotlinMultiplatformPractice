package com.maurosergiorodriguez.professionalfeaturesapp.di

import com.maurosergiorodriguez.professionalfeaturesapp.ui.detail.CharacterDetailViewModel
import com.maurosergiorodriguez.professionalfeaturesapp.ui.home.tabs.characters.CharactersViewModel
import com.maurosergiorodriguez.professionalfeaturesapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}