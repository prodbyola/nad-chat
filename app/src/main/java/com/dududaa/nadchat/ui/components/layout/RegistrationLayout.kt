package com.dududaa.nadchat.ui.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dududaa.nadchat.R
import com.dududaa.nadchat.ui.components.common.NadButton

@Composable
fun RegistrationLayout(content: @Composable () -> Unit){
    val config = LocalConfiguration.current
    val ts = (config.screenHeightDp / 100) * 12

    Column {
        Spacer(modifier = Modifier.height(ts.dp))
        content()
        Spacer(modifier = Modifier.weight(1f))
        NadButton(label = stringResource(id = R.string._continue)) {}
    }
}