package com.dududaa.nadchat.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.theme.ArchivoFont

@Composable
fun ChatComponent(
    contactName: String,
    msgPreview: String,
    msgTime: String,
    avatar: Int? = null,
    read: Boolean = true
){
    val textColor = if(read) Color(0xFF838383) else Color.Black
    val avatarMod = Modifier
        .size(60.dp)
        .clip(CircleShape)

    Column {
        Row(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(avatar != null ) Image(
                painter = painterResource(id = avatar),
                contentDescription = contactName,
                contentScale = ContentScale.Crop,
                modifier = avatarMod
            ) else Box(
                contentAlignment = Alignment.Center,
                modifier = avatarMod.background(color = Color(0xFF4287f5))
            ){
                Text(
                    text = contactName.first().toString().uppercase(),
                    fontSize = 34.sp,
                    color = Color.White,
                    fontFamily = ArchivoFont,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Text(
                        text = contactName,
                        fontFamily = ArchivoFont,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f),
                        color = textColor
                    )
                    Text(
                        text = msgTime,
                        fontFamily = ArchivoFont,
                        fontSize = 12.sp,
                        color = Color(0XFF838383)
                    )
                }

                Text(
                    text = msgPreview,
                    fontFamily = ArchivoFont,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(180.dp),
                    color = textColor
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ChatComponentPreview(){
    ChatComponent(
        "Ajayi Olamide",
        "I really love working with JC!",
        "Now",
        R.drawable.a1
    )
}