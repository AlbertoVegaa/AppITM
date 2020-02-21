@file:Suppress("DEPRECATION")

package com.alberto.emprendete.ui.pantallaE

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenCuatro : Fragment() {

    private lateinit var ScreenCuatroViewModel: screenCuatroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenCuatroViewModel =
            ViewModelProviders.of(this).get(screenCuatroViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_e, container, false)
        val textView: TextView = root.findViewById(R.id.text_p4)
        ScreenCuatroViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}