package com.alberto.emprendete.ui.pantallaA

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenCeroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaA Fragment"
    }
    val text: LiveData<String> = _text

}