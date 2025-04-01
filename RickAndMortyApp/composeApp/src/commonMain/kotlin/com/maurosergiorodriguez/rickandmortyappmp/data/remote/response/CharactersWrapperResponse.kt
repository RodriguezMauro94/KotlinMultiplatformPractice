package com.maurosergiorodriguez.rickandmortyappmp.data.remote.response

data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)

data class InfoResponse(
    val pages: Int,
    val next: String?,
    val prev: String?
)
