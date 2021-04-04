package com.example.guatepreviene.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstadisticasViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Estadísticas COVID-19"
    }
    val text: LiveData<String> = _text
}