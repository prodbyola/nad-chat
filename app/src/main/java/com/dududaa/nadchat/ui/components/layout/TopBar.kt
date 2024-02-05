package com.dududaa.nadchat.ui.components.layout

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NadTopBar(){
    val actionIcons = listOf(R.drawable.camera_icon, R.drawable.edit_icon)

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Chat",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
        },
        actions = {
            actionIcons.forEach { icon ->
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                    )
                }
            }
        }
    )
}