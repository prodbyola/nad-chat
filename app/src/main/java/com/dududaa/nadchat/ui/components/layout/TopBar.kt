package com.dududaa.nadchat.ui.components.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dududaa.nadchat.AppRoute
import com.dududaa.nadchat.icons
import com.dududaa.nadchat.showTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NadTopBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route
    val currentRoute = AppRoute.fromName(route)

    var title by remember {
        mutableStateOf("Chat")
    }

    CenterAlignedTopAppBar(
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }                  
            }
        },
        title = {
            if (currentRoute != null) {
                if(currentRoute.showTitle()){
                    Text(
                        text = "No Title",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
            }
        },
        actions = {
            currentRoute?.icons()?.forEach { icon ->

                IconButton(onClick = {
                    title = "Clicked"
                }) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                    )
                }
            }
        }
    )
}