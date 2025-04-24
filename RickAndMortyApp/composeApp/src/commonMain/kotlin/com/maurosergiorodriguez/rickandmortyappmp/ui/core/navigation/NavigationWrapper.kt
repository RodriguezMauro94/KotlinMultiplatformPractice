package com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.maurosergiorodriguez.rickandmortyappmp.domain.model.CharacterModel
import com.maurosergiorodriguez.rickandmortyappmp.ui.detail.CharacterDetailScreen
import com.maurosergiorodriguez.rickandmortyappmp.ui.home.HomeScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
   val mainNavController = rememberNavController()

   NavHost(navController = mainNavController, startDestination = Routes.Home.route) {
       composable(route = Routes.Home.route) {
           HomeScreen(mainNavController)
       }
       composable<CharacterDetail> { navBackStackEntry ->
           val characterDetailEncoding = navBackStackEntry.toRoute<CharacterDetail>()
           val characterModel = Json.decodeFromString<CharacterModel>(characterDetailEncoding.characterModel)
           CharacterDetailScreen(
               characterModel
           )
       }
   }
}