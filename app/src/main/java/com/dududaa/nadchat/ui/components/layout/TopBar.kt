package com.dududaa.nadchat.ui.components.layout

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
import com.dududaa.nadchat.R

fun getIconName(icon: Int): String{
    return when(icon) {
        R.drawable.edit_icon -> "Edit"
        R.drawable.camera_icon -> "Camera"
        else -> "Person"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NadTopBar(route: String? = null, onIconClicked: (icon: String) -> Unit){
    var actionIcons = listOf(R.drawable.camera_icon, R.drawable.edit_icon)

    if(route == "Profile"){
        actionIcons = listOf(R.drawable.person)
    }

    var title by remember {
        mutableStateOf("Chat")
    }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = route ?: "No Route Name",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
        },
        actions = {
            actionIcons.forEach { icon ->
                val iconName = getIconName(icon)

                IconButton(onClick = {
                    title = "Clicked"
                    onIconClicked(iconName)
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