package com.dududaa.nadchat.network

import com.dududaa.nadchat.data.CountryCode
import retrofit2.http.GET

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T): ApiState<T>()
    data class Error(val msg: String): ApiState<Nothing>()
}

interface ApiService {
    @GET("/public/country-codes")
    suspend fun getCountryCodes(): List<CountryCode>
}