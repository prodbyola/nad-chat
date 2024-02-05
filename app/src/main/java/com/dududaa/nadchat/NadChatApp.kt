package com.dududaa.nadchat

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dududaa.nadchat.ui.components.layout.NadBottomBar
import com.dududaa.nadchat.ui.components.layout.NadTopBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NadChatApp(){
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            NadTopBar()
        },
        bottomBar = {
            NadBottomBar(navController = navController)
        }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Composable
@Preview(showBackground = true)
fun NadChatAppPreview(){
    NadChatApp()
}
