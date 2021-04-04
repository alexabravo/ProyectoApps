package com.example.guatepreviene.ui.response

data class EstadisticasResponse(
    val lastUpdate: String,
    val country: String,
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int,
    val enable: Int
)