package com.example.guatepreviene.ui.api

import com.example.guatepreviene.ui.response.EstadisticasResponse
import retrofit2.http.GET

interface EstadisticasApi {
    @GET("covid")
    suspend fun getStatistics(): EstadisticasResponse
}