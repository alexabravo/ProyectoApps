package com.example.guatepreviene.ui.api

import com.example.guatepreviene.ui.response.NoticiasResponse
import retrofit2.http.GET

interface NoticiasApi {
    @GET("news")
    suspend fun getNews(): NoticiasResponse
}