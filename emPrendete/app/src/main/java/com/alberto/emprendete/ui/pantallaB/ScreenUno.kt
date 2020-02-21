@file:Suppress("DEPRECATION")

package com.alberto.emprendete.ui.pantallaB
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R
import com.bumptech.glide.Glide

class ScreenUno : Fragment() {
    private lateinit var ScreenUnoViewModel: screenUnoViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ScreenUnoViewModel = ViewModelProviders.of(this).get(screenUnoViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_b, container, false)
        val textView: TextView = root.findViewById(R.id.text_p1)
        ScreenUnoViewModel.text.observe(this, Observer {textView.text = it})

        val saludo = root.findViewById<TextView>(R.id.saludito)
        saludo.text = " Saludos de parte de toda la institucion tecnologica de matamoros y puro pinche cartel de santa alv compa"
        saludo.setSingleLine()
        saludo.ellipsize=TextUtils.TruncateAt.MARQUEE
        saludo.marqueeRepeatLimit = -1
        saludo.isSelected=true

        val utm = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/utm.jpg?alt=media&token=407b39d5-61fa-43e1-8b19-3f1678b19bab"
        Glide.with(this).load(utm).into(root.findViewById(R.id.img1))
        val utm = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/utm.jpg?alt=media&token=407b39d5-61fa-43e1-8b19-3f1678b19bab"
        Glide.with(this).load(utm).into(root.findViewById(R.id.img1))
        return root
    }
}