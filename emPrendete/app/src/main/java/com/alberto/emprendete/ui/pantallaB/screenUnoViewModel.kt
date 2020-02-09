package com.alberto.emprendete.ui.pantallaB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenUnoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaB Fragment"
    }
    val text: LiveData<String> = _text
}