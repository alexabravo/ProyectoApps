package com.example.guatepreviene.ui.api

import com.example.guatepreviene.ui.response.EmergenciasResponse
import retrofit2.http.GET

interface EmergenciasApi {
    @GET("information")
    suspend fun getPhones(): EmergenciasResponse
}