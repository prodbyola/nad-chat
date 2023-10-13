package com.dududaa.nadchat.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dududaa.nadchat.R

data class RecentChat(
    val contactName: String,
    val msgPreview: String,
    val msgTime: String,
    val avatar: Int? = null,
    val read: Boolean = true,
)

val chats = listOf(
    RecentChat(
        "Ajayi Oluwatoyin",
        "I really enjoyed working with JC.",
        "Now",
        R.drawable.a2,
        false,
    ),
    RecentChat(
        "Ogunsanya Joshua",
        "Dududaa made JC easy to leann",
        "15min",
        R.drawable.a1,
        false,
    ),
    RecentChat(
        "Jude Emeka",
        "Please tell me more. I'll love to learn.",
        "22min",
    ),
    RecentChat(
        "AIRTnD CEO",
        "Looking forward to bringing in my team",
        "1hr",
        R.drawable.a3
    ),
    RecentChat(
        "Santa Boss",
        "Thanks Dududaa!",
        "1hr"
    ),
    RecentChat(
        "Fireboy",
        "Hey, just dropped another banger!",
        "10/08/23",
        R.drawable.a4
    ),
    RecentChat(
        "My Mum",
        "When are you coming home?",
        "13/08/23"
    ),
    RecentChat(
        "Office Secretary",
        "Ok sir.",
        "04/05/23",
        R.drawable.a5
    ),
)

@Composable
fun ChatListComponent(){
    LazyColumn {
            items(chats) { chat -> ChatComponent(
                contactName = chat.contactName,
                msgPreview = chat.msgPreview,
                msgTime = chat.msgTime,
                avatar = chat.avatar,
                read = chat.read
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListComponentPreview(){
    ChatListComponent()
}