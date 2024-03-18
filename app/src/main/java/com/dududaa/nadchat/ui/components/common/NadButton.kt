package com.dududaa.nadchat.ui.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.ui.theme.ArchivoFont

@Composable
fun NadButton(
    label: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),
    color: Color = Color.Black,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        )
    ) {
        Text(
            text = label,
            fontFamily = ArchivoFont,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = textColor
        )
    }
}