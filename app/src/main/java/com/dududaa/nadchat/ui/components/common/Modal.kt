package com.dududaa.nadchat.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun NadModal(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(modifier = modifier){
            content()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NadModalPreview(){
    NadModal(onDismiss = { /*TODO*/ }) {
        Text(text = "I am a Dialog")
    }
}