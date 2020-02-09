package com.alberto.emprendete.ui.pantallaI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenOcho : Fragment() {

    private lateinit var ScreenOchoViewModel: screenOchoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenOchoViewModel=
            ViewModelProviders.of(this).get(screenOchoViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_i, container, false)
        val textView: TextView = root.findViewById(R.id.text_p8)
        ScreenOchoViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}