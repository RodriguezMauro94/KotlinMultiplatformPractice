package com.maurosergiorodriguez.rickandmortyappmp.data.remote

import com.maurosergiorodriguez.rickandmortyappmp.data.remote.response.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {
    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get("/api/character/$id").body()
    }
}