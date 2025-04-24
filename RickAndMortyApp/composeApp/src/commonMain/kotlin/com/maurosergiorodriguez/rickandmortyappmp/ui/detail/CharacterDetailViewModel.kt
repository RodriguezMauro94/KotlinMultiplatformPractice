package com.maurosergiorodriguez.rickandmortyappmp.ui.detail

import androidx.lifecycle.ViewModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterDetailViewModel(
    val characterModel: CharacterModel
): ViewModel() {
    private val _uiState = MutableStateFlow(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState

}