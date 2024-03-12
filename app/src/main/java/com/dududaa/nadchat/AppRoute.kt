package com.dududaa.nadchat

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dududaa.nadchat.ui.screens.ChatListScreen
import com.dududaa.nadchat.ui.screens.ChatRoomScreen
import com.dududaa.nadchat.ui.screens.ContactsScreen
import com.dududaa.nadchat.ui.screens.ProfileScreen

enum class AppRoute {
    RecentChats,
    ChatRoom,
    Contacts,
    Profile,
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier,
    iconClicked: String
) {
    Box(modifier = modifier){
        NavHost(
            navController = navController,
            startDestination = AppRoute.RecentChats.name
        ) {
            composable(route = AppRoute.RecentChats.name) {
                ChatListScreen()
            }

            composable(route = AppRoute.ChatRoom.name) {
                ChatRoomScreen()
            }

            composable(route = AppRoute.Contacts.name){
                ContactsScreen(iconClicked)
            }

            composable(route = AppRoute.Profile.name){
                ProfileScreen(iconClicked)
            }
        }
    }
}