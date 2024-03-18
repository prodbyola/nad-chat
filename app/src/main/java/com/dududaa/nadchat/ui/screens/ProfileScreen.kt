package com.dududaa.nadchat.ui.screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(
    iconClicked: String
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "Profile Screen Here", color = Color.Black)
            Text(text = "Icon clicked is $iconClicked")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview(){
    ProfileScreen(iconClicked = "Edit")
}