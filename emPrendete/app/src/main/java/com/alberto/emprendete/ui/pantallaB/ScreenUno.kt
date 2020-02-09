package com.alberto.emprendete.ui.pantallaB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenUno : Fragment() {

    private lateinit var ScreenUnoViewModel: screenUnoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ScreenUnoViewModel =
            ViewModelProviders.of(this).get(screenUnoViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_b, container, false)
        val textView: TextView = root.findViewById(R.id.text_p1)
        ScreenUnoViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}