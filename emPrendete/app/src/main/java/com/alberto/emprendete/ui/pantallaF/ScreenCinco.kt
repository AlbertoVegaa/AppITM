package com.alberto.emprendete.ui.pantallaF

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenCinco : Fragment() {

    private lateinit var ScreenCincoViewModel: screenCincoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenCincoViewModel =
            ViewModelProviders.of(this).get(screenCincoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        ScreenCincoViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}