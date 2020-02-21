@file:Suppress("DEPRECATION")

package com.alberto.emprendete.ui.pantallaF


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R
import com.bumptech.glide.Glide


class ScreenCinco : Fragment() {

    private lateinit var ScreenCincoViewModel: screenCincoViewModel
    private lateinit var imageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        ScreenCincoViewModel = ViewModelProviders.of(this).get(screenCincoViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_f, container, false)
        val textView: TextView = root.findViewById(R.id.text_p5)
        ScreenCincoViewModel.text.observe(this, Observer {textView.text = it })

        imageView = root.findViewById(R.id.imagen)

        val url = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/yo.png?alt=media&token=f58966d7-9a4a-44be-96c1-7924c1e10c5e"

        //Glide.with(this).load(url).into(imageView)
        Glide.with(this).load(url).into(imageView)

        return root
    }
}