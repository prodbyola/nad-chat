package com.dududaa.nadchat.ui.screens.registration

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dududaa.nadchat.R
import com.dududaa.nadchat.data.CountryCode
import com.dududaa.nadchat.ui.components.common.CountryCodeSheet
import com.dududaa.nadchat.ui.components.layout.RegistrationLayout
import com.dududaa.nadchat.ui.theme.ArchivoFont
import com.dududaa.nadchat.ui.theme.ClashDisplayFont
import com.dududaa.nadchat.ui.viewmodels.CountryCodeViewModel

@Composable
fun AddPhoneScreen(codesViewModel: CountryCodeViewModel = viewModel()) {
    var showOnboard by remember {
        mutableStateOf(true)
    }

    var showCodes by remember {
        mutableStateOf(false)
    }

    var countryCode by remember {
        mutableStateOf(CountryCode(name = "Nigeria", dial_code = "+234", code = "NG"))
    }

    if (showOnboard) {
        OnboardScreen {
            showOnboard = false
        }
    }

    if (showCodes) {
        CountryCodeSheet(viewModel = codesViewModel, onDismiss = { showCodes = false }) {
            countryCode = it
        }
    }

    val textColor = Color(0XFF7B7B7B)
    val strokeColor = Color(0XFFCFCFCF)

    var phone by remember {
        mutableStateOf("")
    }

    val fieldPadding = 24.dp

    RegistrationLayout {
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
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .height(56.dp)
                        .border(border = BorderStroke(1.dp, strokeColor)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(start = fieldPadding)
                            .clickable { showCodes = true }
                    ) {
                        Text(text = countryCode.dial_code)
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

                    Box(modifier = Modifier
                        .weight(1f)
                        .padding(end = fieldPadding)) {
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
    }
}

@Composable
@Preview(showBackground = true)
fun AddPhonePreview() {
    AddPhoneScreen()
}