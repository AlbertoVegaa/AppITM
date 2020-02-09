package com.alberto.emprendete.ui.pantallaF

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenCincoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaF Fragment"
    }
    val text: LiveData<String> = _text
}