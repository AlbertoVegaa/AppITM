package com.alberto.emprendete.ui.pantallade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R

class ScreenTres : Fragment() {

    private lateinit var ScreenTresViewModel: screenTresViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ScreenTresViewModel =
            ViewModelProviders.of(this).get(screenTresViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tools, container, false)
        val textView: TextView = root.findViewById(R.id.text_tools)
        ScreenTresViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}