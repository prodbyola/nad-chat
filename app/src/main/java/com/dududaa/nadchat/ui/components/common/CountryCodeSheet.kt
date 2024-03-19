package com.dududaa.nadchat.ui.components.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.dududaa.nadchat.data.CountryCode
import com.dududaa.nadchat.network.ApiState
import com.dududaa.nadchat.ui.viewmodels.CountryCodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCodeSheet(viewModel: CountryCodeViewModel, onDismiss: () -> Unit){
    val codeState by viewModel.codes.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCodes()
    }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        when(codeState) {
            is ApiState.Loading -> {
                Text(text = "Loading")
            }

            is ApiState.Success -> {
                val codes = (codeState as ApiState.Success<List<CountryCode>>).data
                LazyColumn {
                    items(codes) { code ->
                        Text(text = code.name)
                    }
                }
            }

            is ApiState.Error -> {
                val err = (codeState as ApiState.Error).msg
                Text(text = err)
            }

            null -> {
                Text(text = "Null")
            }
        }
    }
}