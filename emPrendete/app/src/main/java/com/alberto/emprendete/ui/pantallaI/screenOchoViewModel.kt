package com.alberto.emprendete.ui.pantallaI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenOchoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaI Fragment"
    }
    val text: LiveData<String> = _text
}