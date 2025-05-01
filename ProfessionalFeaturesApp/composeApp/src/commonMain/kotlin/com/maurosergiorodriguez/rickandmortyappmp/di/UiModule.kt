package com.maurosergiorodriguez.rickandmortyappmp.di

import com.maurosergiorodriguez.rickandmortyappmp.ui.detail.CharacterDetailViewModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters.CharactersViewModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}