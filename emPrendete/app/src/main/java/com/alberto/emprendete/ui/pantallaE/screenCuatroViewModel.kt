package com.alberto.emprendete.ui.pantallaE

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class screenCuatroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is pantallaE Fragment"
    }
    val text: LiveData<String> = _text
}