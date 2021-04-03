package com.example.guatepreviene.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NoticiasViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Lista Noticias"
    }
    val text: LiveData<String> = _text
}