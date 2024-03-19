package com.dududaa.nadchat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dududaa.nadchat.ui.screens.ChatListScreen
import com.dududaa.nadchat.ui.screens.ChatRoomScreen
import com.dududaa.nadchat.ui.screens.ContactsScreen
import com.dududaa.nadchat.ui.screens.ProfileScreen
import com.dududaa.nadchat.ui.screens.registration.AddPhoneScreen
import com.dududaa.nadchat.ui.viewmodels.CountryCodeViewModel

enum class AppRoute {
    RecentChats,
    ChatRoom,
    Contacts,
    Profile,
    RegAddPhone,
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier,
    iconClicked: String,
    codesViewModel: CountryCodeViewModel
) {
    Box(modifier = modifier.padding(horizontal = 24.dp)){
        NavHost(
            navController = navController,
            startDestination = AppRoute.RegAddPhone.name
        ) {
            composable(route = AppRoute.RegAddPhone.name){
                AddPhoneScreen(codesViewModel)
            }

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