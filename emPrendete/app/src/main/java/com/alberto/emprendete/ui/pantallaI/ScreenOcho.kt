package com.alberto.emprendete.ui.pantallaI
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
import com.bumptech.glide.Glide
private lateinit var contenedor_imagen1: ImageView

class ScreenOcho : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.pantalla_i, container, false)

        var url = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/yo.png?alt=media&token=f58966d7-9a4a-44be-96c1-7924c1e10c5e"

        contenedor_imagen1 =  root.findViewById(R.id.desarrollador1)
        Glide.with(this).load(url).into(contenedor_imagen1)
        return root
    }
}