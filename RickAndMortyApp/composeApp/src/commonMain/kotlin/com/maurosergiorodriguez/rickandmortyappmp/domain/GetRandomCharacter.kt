package com.maurosergiorodriguez.rickandmortyappmp.domain

class GetRandomCharacter(
    val repository: Repository
) {
    suspend operator fun invoke() {
        val randomId = (1 .. 826).random()
        repository.getSingleCharacter(randomId.toString())
    }
}