package com.alberto.emprendete.ui.pantallaA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenCero : Fragment() {

    private lateinit var ScreenCeroViewModel: screenCeroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenCeroViewModel =
            ViewModelProviders.of(this).get(screenCeroViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_a, container, false)
        val textView: TextView = root.findViewById(R.id.text_p0)
        ScreenCeroViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}