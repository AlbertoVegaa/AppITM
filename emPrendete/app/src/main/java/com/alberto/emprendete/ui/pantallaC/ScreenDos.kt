package com.alberto.emprendete.ui.pantallaC

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenDos : Fragment() {

    private lateinit var ScreenDosViewModel: screenDosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenDosViewModel =
            ViewModelProviders.of(this).get(screenDosViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_c, container, false)
        val textView: TextView = root.findViewById(R.id.text_p2)
        ScreenDosViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}