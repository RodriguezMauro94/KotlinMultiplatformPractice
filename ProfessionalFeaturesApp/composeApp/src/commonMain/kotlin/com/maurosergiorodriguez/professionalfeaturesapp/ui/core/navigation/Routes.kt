package com.maurosergiorodriguez.professionalfeaturesapp.ui.core.navigation

import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

sealed class Routes(val route: String) {
    data object Login: Routes("login")
    data object Home: Routes("home")
    data object Firestore: Routes("firestore")

    // BottomNavigation
    data object Episodes: Routes("episodes")
    data object Characters: Routes("characters")
}

@Serializable
data class CharacterDetail(val characterModel: String)