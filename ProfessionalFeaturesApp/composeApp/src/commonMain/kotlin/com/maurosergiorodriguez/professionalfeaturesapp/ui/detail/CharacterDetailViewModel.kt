package com.maurosergiorodriguez.professionalfeaturesapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maurosergiorodriguez.professionalfeaturesapp.domain.Repository
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterDetailViewModel(
    val characterModel: CharacterModel,
    val repository: Repository
): ViewModel() {
    private val _uiState = MutableStateFlow(CharacterDetailState(characterModel))
    val uiState: StateFlow<CharacterDetailState> = _uiState

    init {
        getEpisodesForCharacter(characterModel.episodes)
    }

    private fun getEpisodesForCharacter(episodes: List<String>) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getEpisodesForCharacter(episodes)
            }
            _uiState.update { it.copy(episodes = result) }
        }
    }
}