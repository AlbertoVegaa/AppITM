package com.alberto.emprendete.ui.pantallaI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ScreenOcho : Fragment() {
    private lateinit var myDatabase: DatabaseReference
    private lateinit var ScreenOchoViewModel: screenOchoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        ScreenOchoViewModel= ViewModelProviders.of(this).get(screenOchoViewModel::class.java)
        val root = inflater.inflate(R.layout.pantalla_i, container, false)
        val textView: TextView = root.findViewById(R.id.text_p8)
        ScreenOchoViewModel.text.observe(this, Observer {textView.text = it })
        // ================================================
        myDatabase = FirebaseDatabase.getInstance().reference

        val etiquetaNombre = root.findViewById<EditText>(R.id.nombreEt)
        val etiquetaApellido = root.findViewById<EditText>(R.id.apellidoEt)
        val etiquetaEdad = root.findViewById<EditText>(R.id.edadEt)
        val rating = root.findViewById<RatingBar>(R.id.ratingBar)
        val validacionCB = root.findViewById<CheckBox>(R.id.mexicanCB)
        val aceptarBtn = root.findViewById<Button>(R.id.aceptar)

        aceptarBtn.setOnClickListener {
            var nombre = etiquetaNombre.text.toString()
            var apellido = etiquetaApellido.text.toString()
            var edad = (etiquetaEdad.text.toString()).toInt()
            var mexican: String
            var stars = rating.rating.toDouble()

            if (validacionCB.isChecked) {
                mexican = "Mexicano"
            } else {
                mexican = "Extranjero"
            }
            val userId = myDatabase.push().key.toString()
            val user = Usuarios(userId, nombre, apellido, edad, stars, mexican)
            myDatabase.child("participantes").child(userId).setValue(user)
            Toast.makeText(activity, "anadido", Toast.LENGTH_LONG).show()
        }
            // ================================================
        return root
    }
}
class Usuarios (var id:String, var nombre:String, var apellido:String, var edad:Int, var stars:Double, var nacionalidad:String){

    constructor():this("","","", 0,0.0, "")
}