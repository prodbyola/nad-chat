package com.dududaa.nadchat.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dududaa.nadchat.ui.components.ChatListComponent
import com.dududaa.nadchat.ui.components.SearchField

@Composable
fun ChatListScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchField()
        Spacer(modifier = Modifier.height(16.dp))
        ChatListComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview(){
    ChatListScreen()
}