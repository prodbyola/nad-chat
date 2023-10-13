package com.dududaa.nadchat.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.ui.theme.ArchivoFont

@Composable
fun SearchField() {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    val textColor = Color(0x993c3c43)

    BasicTextField(
        value = "",
        onValueChange = { text = it },
        decorationBox = {innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(
                        color = Color(0x1F767680),
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(horizontal = 6.dp)
                    .height(36.dp)
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = textColor,
                    modifier = Modifier.size(21.dp)
                )
                Box(modifier = Modifier.weight(1f)) {
                    if(text.isEmpty()) Text(
                        text = "Search",
                        fontSize = 17.sp,
                        lineHeight = 22.sp,
                        color = textColor,
                        fontFamily = ArchivoFont
                    )

                    innerTextField()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchFieldPreview(){
    SearchField()
}