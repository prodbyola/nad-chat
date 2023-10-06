package com.dududaa.nadchat.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dududaa.nadchat.ui.components.ChatListComponent

@Composable
fun ChatListScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ChatListComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview(){
    ChatListScreen()
}