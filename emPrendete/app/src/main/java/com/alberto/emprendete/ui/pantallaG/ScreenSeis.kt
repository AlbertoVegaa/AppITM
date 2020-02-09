package com.alberto.emprendete.ui.pantallaG

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenSeis : Fragment() {

    private lateinit var ScreenSeisViewModel: screenSeisViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenSeisViewModel=
            ViewModelProviders.of(this).get(screenSeisViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_g, container, false)
        val textView: TextView = root.findViewById(R.id.text_p6)
        ScreenSeisViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}