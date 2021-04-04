package com.example.guatepreviene.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmergenciasViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Números de emergencia"
    }
    val text: LiveData<String> = _text
}
