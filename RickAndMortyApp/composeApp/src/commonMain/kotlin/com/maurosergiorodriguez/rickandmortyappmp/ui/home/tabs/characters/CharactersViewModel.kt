package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.GetRandomCharacter

class CharactersViewModel(
    val randomCharacter: GetRandomCharacter
): ViewModel() {

}