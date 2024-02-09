package com.dududaa.nadchat.ui.components.layout

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dududaa.nadchat.AppRoute
import com.dududaa.nadchat.R

sealed class Destinations(
    val route: AppRoute,
    val title: String,
    val icon: Int
) {
    object Chats : Destinations(
        route = AppRoute.RecentChats,
        icon = R.drawable.chat,
        title = "Chats"
    )

    object Contacts : Destinations(
        route = AppRoute.Contacts,
        icon = R.drawable.group,
        title = "Contacts"
    )

    object Profile : Destinations(
        route = AppRoute.Profile,
        icon = R.drawable.person,
        title = "Profile"
    )
}

@Composable
fun NadBottomBar(
    navController: NavController
) {
    val screens = listOf(
        Destinations.Chats,
        Destinations.Contacts,
        Destinations.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route.name,
                onClick = {
                    navController.navigate(screen.route.name) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = screen.title)
                }
            )
        }
    }
}