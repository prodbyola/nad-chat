package com.dududaa.nadchat.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dududaa.nadchat.data.CountryCode
import com.dududaa.nadchat.network.ApiService
import com.dududaa.nadchat.network.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryCodeViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    private val _codes = MutableLiveData<ApiState<List<CountryCode>>>(ApiState.Loading)

    val codes: LiveData<ApiState<List<CountryCode>>> = _codes

    fun loadCodes(){
        viewModelScope.launch {
            try {
                val resp = apiService.getCountryCodes()
                _codes.value = ApiState.Success(resp)
            } catch (e: Exception) {
                _codes.value = ApiState.Error(e.message.toString())
            }
        }
    }
}