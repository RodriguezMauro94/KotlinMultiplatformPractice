package com.maurosergiorodriguez.rickandmortyappmp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.bottomBarNavigation.BottomBarItem
import com.maurosergiorodriguez.rickandmortyappmp.ui.core.navigation.bottomBarNavigation.NavigationBottomWrapper

@Composable
fun HomeScreen(mainNavController: NavHostController) {
    val bottomBarItems = listOf(
        BottomBarItem.Episodes(),
        BottomBarItem.Characters()
    )
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(bottomBarItems, navController) }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            NavigationBottomWrapper(navController, mainNavController)
        }
    }
}

@Composable
fun BottomNavigation(bottomBarItems: List<BottomBarItem>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        bottomBarItems.forEach { item ->
            NavigationBarItem(
                icon = item.icon,
                label = { Text(item.title) },
                onClick = {
                    navController.navigate(route = item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            )
        }
    }
}