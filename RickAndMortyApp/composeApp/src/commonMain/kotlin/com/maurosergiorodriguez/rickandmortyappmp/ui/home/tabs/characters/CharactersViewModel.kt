package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.maurosergiorodriguez.rickandmortyappmp.domain.GetRandomCharacter
import com.maurosergiorodriguez.rickandmortyappmp.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(
    val getRandomCharacter: GetRandomCharacter,
    private val repository: Repository
): ViewModel() {
    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { state -> state.copy(characterOfTheDay = result) }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _state.update { state -> state.copy(characters = repository.getAllCharacters().cachedIn(viewModelScope)) }
    }
}