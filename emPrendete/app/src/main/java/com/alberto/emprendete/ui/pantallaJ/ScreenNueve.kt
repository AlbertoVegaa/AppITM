package com.alberto.emprendete.ui.pantallaJ
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
class ScreenNueve : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_j, container, false)
        return root
    }
}
