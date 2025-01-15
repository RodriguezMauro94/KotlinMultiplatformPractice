package com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation

sealed class Routes(val route: String) {
    data object Home: Routes("home")

    // BottomNavigation
    data object Episodes: Routes("episodes")
    data object Characters: Routes("characters")
}