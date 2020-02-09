package com.alberto.emprendete.ui.pantallaG

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenSeisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaG Fragment"
    }
    val text: LiveData<String> = _text
}