package com.dududaa.nadchat.ui.screens.registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.components.common.NadButton
import com.dududaa.nadchat.ui.theme.ArchivoFont
import com.dududaa.nadchat.ui.theme.ClashDisplayFont

@Composable
fun AddPhoneScreen() {
    var showOnboard by remember {
        mutableStateOf(false)
    }

    if (showOnboard) {
        OnboardScreen {
            showOnboard = false
        }
    }

    val textColor = Color(0XFF7B7B7B)
    var phone by remember {
        mutableStateOf("")
    }

    Column {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.whats_your_phone),
            fontFamily = ClashDisplayFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 44.sp
        )
        Text(
            text = stringResource(id = R.string.confirm_country_code),
            fontFamily = ArchivoFont,
            fontSize = 16.sp
        )
        BasicTextField(
            value = phone,
            onValueChange = { phone = it },
            decorationBox = { innerTextField ->
                Row {
                    Box(modifier = Modifier.weight(1f)) {
                        if (phone.isEmpty()) Text(
                            text = stringResource(id = R.string.enter_phone),
                            fontSize = 16.sp,
                            color = textColor,
                            fontFamily = ArchivoFont
                        )
                        innerTextField()
                    }
                }
            }
        )

        Spacer(modifier = Modifier.weight(1f))
        NadButton(label = stringResource(id = R.string._continue)) {}
    }
}