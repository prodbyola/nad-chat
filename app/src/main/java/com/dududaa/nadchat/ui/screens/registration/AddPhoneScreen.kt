package com.dududaa.nadchat.ui.screens.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.components.common.CountryCodeSheet
import com.dududaa.nadchat.ui.components.common.NadButton
import com.dududaa.nadchat.ui.theme.ArchivoFont
import com.dududaa.nadchat.ui.theme.ClashDisplayFont
import com.dududaa.nadchat.ui.viewmodels.CountryCodeViewModel

@Composable
fun AddPhoneScreen(codesViewModel: CountryCodeViewModel = viewModel()) {
    var showOnboard by remember {
        mutableStateOf(false)
    }

    var showCodes by remember {
        mutableStateOf(false)
    }

    if (showOnboard) {
        OnboardScreen {
            showOnboard = false
        }
    }

    if (showCodes) {
        CountryCodeSheet(viewModel = codesViewModel) {
            showCodes = false
        }
    }

    val textColor = Color(0XFF7B7B7B)
    val strokeColor = Color(0XFFCFCFCF)

    var phone by remember {
        mutableStateOf("")
    }

    val config = LocalConfiguration.current
    val ts = (config.screenHeightDp / 100) * 12

    Column {
        Spacer(modifier = Modifier.height(ts.dp))
        Text(
            text = stringResource(id = R.string.whats_your_phone),
            fontFamily = ClashDisplayFont,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 44.sp
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = stringResource(id = R.string.confirm_country_code),
            fontFamily = ArchivoFont,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(22.dp))
        BasicTextField(
            value = phone,
            onValueChange = { phone = it },
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .height(56.dp)
                        .border(border = BorderStroke(1.dp, strokeColor))
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { showCodes = true }) {
                        Text(text = "+234")
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(1.dp)
                            .background(color = strokeColor)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

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

@Composable
@Preview(showBackground = true)
fun AddPhonePreview() {
    AddPhoneScreen()
}