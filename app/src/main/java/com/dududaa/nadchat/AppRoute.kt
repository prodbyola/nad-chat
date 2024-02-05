package com.dududaa.nadchat

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dududaa.nadchat.ui.screens.ChatListScreen
import com.dududaa.nadchat.ui.screens.ChatRoomScreen

enum class AppRoute {
    RecentChats,
    ChatRoom,
    Contacts,
    Profile
}

@Composable
fun NavigationGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = AppRoute.RecentChats.name){
        composable(route = AppRoute.RecentChats.name){
            ChatListScreen()
        }

        composable(route = AppRoute.ChatRoom.name){
            ChatRoomScreen()
        }
    }
}