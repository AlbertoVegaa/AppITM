package com.alberto.emprendete.ui.pantallaC

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenDosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaC Fragment"
    }
    val text: LiveData<String> = _text
}