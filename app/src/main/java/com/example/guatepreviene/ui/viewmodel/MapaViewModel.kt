package com.example.guatepreviene.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapaViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Mapa de centros de atención"
    }
    val text: LiveData<String> = _text
}