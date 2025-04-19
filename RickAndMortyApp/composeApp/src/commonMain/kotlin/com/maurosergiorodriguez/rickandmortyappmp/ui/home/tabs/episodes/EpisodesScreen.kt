package com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.EpisodeModel
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.SeasonEpisode
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingLoadingState
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingType
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.PagingWrapper
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.components.VideoPlayer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickandmortyapp.composeapp.generated.resources.Res
import rickandmortyapp.composeapp.generated.resources.season1
import rickandmortyapp.composeapp.generated.resources.season2
import rickandmortyapp.composeapp.generated.resources.season3
import rickandmortyapp.composeapp.generated.resources.season4
import rickandmortyapp.composeapp.generated.resources.season5
import rickandmortyapp.composeapp.generated.resources.season6
import rickandmortyapp.composeapp.generated.resources.season7

@Composable
@OptIn(KoinExperimentalAPI::class)
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    val state by episodesViewModel.state.collectAsState()
    val episodes = state.episodes.collectAsLazyPagingItems()

    Column(modifier = Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            itemView = {
                EpisodeItemList(it) { url ->
                    episodesViewModel.onEpisodeSelected(url)
                }
            }
        )
        if (state.playVideo.isNotBlank()) {
            VideoPlayer(modifier = Modifier.size(200.dp), state.playVideo)
        }
    }
}

@Composable
fun EpisodeItemList(episode: EpisodeModel, onEpisodeSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.width(120.dp).padding(horizontal = 8.dp).clickable {
            onEpisodeSelected(episode.videoURL)
        }
    ) {
        Image(
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisode): DrawableResource {
    return when(seasonEpisode) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.UNKNOWN -> Res.drawable.season1
    }
}