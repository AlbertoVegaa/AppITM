package com.alberto.emprendete.ui.pantallaE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
class ScreenCuatro : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_e, container, false)
        return root
    }
}