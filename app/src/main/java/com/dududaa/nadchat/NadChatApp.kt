package com.dududaa.nadchat

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dududaa.nadchat.ui.components.layout.NadBottomBar
import com.dududaa.nadchat.ui.components.layout.NadTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NadChatApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    var iconClicked by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            NadTopBar(
                route = currentRoute,
                onIconClicked = { icon ->
                    iconClicked = icon
                }
            )
        },
        bottomBar = {
            NadBottomBar(
                navController = navController
            )
        }
    ) {
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(it),
            iconClicked = iconClicked
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NadChatAppPreview() {
    NadChatApp()
}
