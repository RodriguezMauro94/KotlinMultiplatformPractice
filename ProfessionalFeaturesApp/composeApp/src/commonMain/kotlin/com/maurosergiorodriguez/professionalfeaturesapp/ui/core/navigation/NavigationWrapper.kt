package com.maurosergiorodriguez.professionalfeaturesapp.ui.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.maurosergiorodriguez.professionalfeaturesapp.domain.model.CharacterModel
import com.maurosergiorodriguez.professionalfeaturesapp.ui.detail.CharacterDetailScreen
import com.maurosergiorodriguez.professionalfeaturesapp.ui.firebase.firestore.FirestoreScreen
import com.maurosergiorodriguez.professionalfeaturesapp.ui.home.HomeScreen
import com.maurosergiorodriguez.professionalfeaturesapp.ui.login.LoginScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationWrapper() {
   val mainNavController = rememberNavController()

   NavHost(navController = mainNavController, startDestination = Routes.Login.route) {
       composable(route = Routes.Login.route) {
           LoginScreen(mainNavController)
       }
       composable(route = Routes.Home.route) {
           HomeScreen(mainNavController)
       }
       composable(route = Routes.Firestore.route) {
           FirestoreScreen(mainNavController)
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