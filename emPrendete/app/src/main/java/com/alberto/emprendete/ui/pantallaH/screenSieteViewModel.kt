package com.alberto.emprendete.ui.pantallaH

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenSieteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaH Fragment"
    }
    val text: LiveData<String> = _text
}