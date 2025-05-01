package com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation

import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

sealed class Routes(val route: String) {
    data object Home: Routes("home")

    // BottomNavigation
    data object Episodes: Routes("episodes")
    data object Characters: Routes("characters")
}

@Serializable
data class CharacterDetail(val characterModel: String)