package com.alberto.emprendete.ui.pantallade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenTresViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallade Fragment"
    }
    val text: LiveData<String> = _text
}