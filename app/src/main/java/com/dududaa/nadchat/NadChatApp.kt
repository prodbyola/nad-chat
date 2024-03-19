package com.dududaa.nadchat

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dududaa.nadchat.ui.components.layout.NadBottomBar
import com.dududaa.nadchat.ui.components.layout.NadTopBar
import com.dududaa.nadchat.ui.viewmodels.CountryCodeViewModel


@Composable
fun NadChatApp(codesViewModel: CountryCodeViewModel = viewModel()) {
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
            iconClicked = iconClicked,
            codesViewModel
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NadChatAppPreview() {
    NadChatApp()
}
