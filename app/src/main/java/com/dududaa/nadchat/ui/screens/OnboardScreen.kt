package com.dududaa.nadchat.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.ui.components.common.NadModal
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.theme.ArchivoFont
import com.dududaa.nadchat.ui.theme.ClashDisplayFont

private sealed class OnboardData(val img: Int, val title: String) {
    object One : OnboardData(
        img = R.drawable.ob_lock,
        title = "Private & secure",
    )

    object Two : OnboardData(
        img = R.drawable.ob_img,
        title = "Share with comfort",
    )

    object Three : OnboardData(
        img = R.drawable.ob_chat,
        title = "Messages erased",
    )
}

private fun OnboardData.sub(): AnnotatedString {
    val style = SpanStyle(fontWeight = FontWeight.Bold)

    return when(this) {
        OnboardData.One -> buildAnnotatedString {
            append("The world’s most ")
            withStyle(style){
                append("private")
            }
            append(" messaging app.")
        }

        OnboardData.Two -> buildAnnotatedString {
            append("We ")
            withStyle(style){
                append("disable")
            }
            append(" the ability to screenshot.")
        }

        else -> buildAnnotatedString {
            append("You ")
            withStyle(style){
                append("control")
            }
            append(" when messages are deleted.")
        }
    }
}

@Composable
private fun OnboardComponent(data: OnboardData) {
    val imgHeight = if(data == OnboardData.Three) 125 else 100

    Image(
        painter = painterResource(id = data.img),
        contentDescription = null,
        modifier = Modifier
            .height(imgHeight.dp)
            .width(125.dp)
    )

    Spacer(modifier = Modifier.height(104.dp))

    Text(
        text = data.title,
        fontFamily = ClashDisplayFont,
        fontSize = 48.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 49.sp,
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(24.dp))

    Text(text = data.sub(), fontFamily = ArchivoFont, fontSize = 16.sp)
}

@Composable
fun OnboardScreen(onDone: () -> Unit) {
    NadModal(
        onDismiss = onDone, modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .paint(
                painter = painterResource(id = R.drawable.bg_pattern),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnboardComponent(data = OnboardData.One)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardScreenPreview(){
    OnboardScreen {}
}