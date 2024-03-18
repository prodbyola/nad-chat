package com.dududaa.nadchat.ui.screens.registration

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
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
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.components.common.NadButton
import com.dududaa.nadchat.ui.components.common.NadModal
import com.dududaa.nadchat.ui.theme.ArchivoFont
import com.dududaa.nadchat.ui.theme.ClashDisplayFont

private sealed class OnboardInfo(val imgPath: Int, val title: String) {
    object One : OnboardInfo(
        imgPath = R.drawable.ob_lock,
        title = "Private & secure",
    )

    object Two : OnboardInfo(
        imgPath = R.drawable.ob_img,
        title = "Share with comfort",
    )

    object Three : OnboardInfo(
        imgPath = R.drawable.ob_chat,
        title = "Messages erased",
    )

    companion object {
        fun collect(): List<OnboardInfo> {
            return listOf(One, Two, Three)
        }
    }
}

private fun OnboardInfo.sub(): AnnotatedString {
    val style = SpanStyle(fontWeight = FontWeight.Bold)

    return when (this) {
        OnboardInfo.One -> buildAnnotatedString {
            append("The world’s most ")
            withStyle(style) {
                append("private")
            }
            append(" messaging app.")
        }

        OnboardInfo.Two -> buildAnnotatedString {
            append("We ")
            withStyle(style) {
                append("disable")
            }
            append(" the ability to screenshot.")
        }

        else -> buildAnnotatedString {
            append("You ")
            withStyle(style) {
                append("control")
            }
            append(" when messages are deleted.")
        }
    }
}

private fun OnboardInfo.next(): OnboardInfo? {
    return when (this) {
        OnboardInfo.One -> OnboardInfo.Two
        OnboardInfo.Two -> OnboardInfo.Three
        else -> null
    }
}

@Composable
private fun OnboardComponent(info: OnboardInfo) {
    val size = 125
    val imgHeight = if (info == OnboardInfo.Three) 125 else 100

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.size(size.dp)) {
            Image(
                painter = painterResource(id = info.imgPath),
                contentDescription = null,
                modifier = Modifier
                    .height(imgHeight.dp)
                    .width(size.dp)
            )
        }

        Spacer(modifier = Modifier.height(84.dp))

        Text(
            text = info.title,
            fontFamily = ClashDisplayFont,
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 49.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = info.sub(), fontFamily = ArchivoFont, fontSize = 16.sp)
    }

}

@Composable
private fun ProgressComponent(currentInfo: OnboardInfo) {
    val values = OnboardInfo.collect()

    Row {
        values.forEach {
            val i = values.indexOf(it)
            val t = values.indexOf(currentInfo)

            val color = if (i > t) Color(0xFFD9D9D9) else Color.Black

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(color = color, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun OnboardScreen(onDone: () -> Unit) {
    NadModal(
        onDismiss = onDone,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_pattern),
                contentScale = ContentScale.FillBounds
            )
    ) {
        val config = LocalConfiguration.current
        val ts = (config.screenHeightDp / 100) * 20 // space at the top
        var currentInfo by remember {
            mutableStateOf<OnboardInfo>(OnboardInfo.One)
        }

        var visibility by remember {
            mutableStateOf(true)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(ts.dp))
            AnimatedVisibility(
                visible = visibility,
                enter = slideInHorizontally { -40 },
                exit = slideOutHorizontally()
            ) {
                OnboardComponent(info = currentInfo)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ProgressComponent(currentInfo)
            Spacer(modifier = Modifier.weight(1f))
            NadButton(label = "Start Private Chat") {
                val nxt = currentInfo.next()
                if (nxt == null) onDone()
                else {
                    visibility = false
                    currentInfo = nxt
                    visibility = true
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OnboardScreenPreview() {
    OnboardScreen {}
}