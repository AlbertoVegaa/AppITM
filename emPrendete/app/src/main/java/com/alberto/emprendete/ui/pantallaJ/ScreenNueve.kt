package com.alberto.emprendete.ui.pantallaJ
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
class ScreenNueve : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_j, container, false)
        val institucion =
            if (arguments != null) arguments!!.getString("escuela")
            else "email@email.com"
        Toast.makeText(activity, institucion, Toast.LENGTH_LONG).show()

        val head = root.findViewById<TextView>(R.id.head)
        head.setText("Estos son los participantes\nque representan a "+institucion+".")
        return root
    }
}