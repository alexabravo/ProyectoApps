package com.example.guatepreviene.ui.api

import com.example.guatepreviene.ui.response.MapaResponse
import retrofit2.http.GET

interface MapaApi {
    @GET("centres")
    suspend fun getPoints(): MapaResponse
}