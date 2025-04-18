package com.maurosergiorodriguez.rickandmortyappmp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class EpisodesWrapperResponse(
    val info: InfoResponse,
    val result: List<EpisodeResponse>
)