package com.alberto.emprendete.ui.pantallaH

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenSiete : Fragment() {

    private lateinit var ScreenSieteViewModel: screenSieteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenSieteViewModel=
            ViewModelProviders.of(this).get(screenSieteViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_h, container, false)
        val textView: TextView = root.findViewById(R.id.text_p7)
        ScreenSieteViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}