package com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.bottomBarNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.CharacterDetail
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.Routes
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.characters.CharactersScreen
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.tabs.episodes.EpisodesScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun NavigationBottomWrapper(
    navHostController: NavHostController,
    mainNavController: NavHostController
) {
    NavHost(
        navController = navHostController, startDestination = Routes.Episodes.route
    ) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route) {
            CharactersScreen(
                navigateToDetail = { characterModel ->
                    val encode = Json.encodeToString(characterModel)
                    mainNavController.navigate(
                        CharacterDetail(encode)
                    )
                }
            )
        }
    }
}