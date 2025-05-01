package com.maurosergiorodriguez.rickandmortyappmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform