package com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.bottomBarNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.Routes
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters.CharactersScreen
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navHostController: NavHostController) {
    NavHost(
        navController = navHostController, startDestination = Routes.Episodes.route
    ) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route) {
            CharactersScreen()
        }
    }
}