package com.example.guatepreviene.ui.response

import com.example.guatepreviene.ui.utils.EmerResponseVal

data class EmergenciasResponse(
        val `data`: List<EmerResponseVal>,
        val whatsapp_phone: String
)
