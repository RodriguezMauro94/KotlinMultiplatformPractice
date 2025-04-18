package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.maurosergiorodriguez.rickandmortyappmp.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class EpisodesViewModel(private val repository: Repository): ViewModel() {
    private val _state = MutableStateFlow<EpisodeState>(EpisodeState())
    val state: StateFlow<EpisodeState> = _state

    init {
        _state.update { state ->
            state.copy(episodes = repository.getAllEpisodes().cachedIn(viewModelScope ))
        }
    }
}