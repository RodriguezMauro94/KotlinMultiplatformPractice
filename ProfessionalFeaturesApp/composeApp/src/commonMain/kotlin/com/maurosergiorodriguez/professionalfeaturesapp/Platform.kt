package com.maurosergiorodriguez.professionalfeaturesapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform