package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes

import androidx.paging.PagingData
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EpisodeState(
    val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow()
)
