@file:Suppress("DEPRECATION")

package com.alberto.emprendete.ui.pantallaA

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alberto.emprendete.R
import com.google.firebase.database.*

class ScreenCero : Fragment() {
    private lateinit var mTextViewData: TextView
    private lateinit var myDatabase: DatabaseReference

    private lateinit var ScreenCeroViewModel: screenCeroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ScreenCeroViewModel= ViewModelProviders.of(this).get(screenCeroViewModel::class.java)

        val root = inflater.inflate(R.layout.pantalla_a, container, false)
        val textView: TextView = root.findViewById(R.id.textView)
        ScreenCeroViewModel.text.observe(this, Observer { textView.text = it
        })
        // =========================================================
        mTextViewData = root.findViewById(R.id.textviewdata)
        myDatabase = FirebaseDatabase.getInstance().reference

        myDatabase.child("participantes").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    myDatabase.child("participantes").child(snapshot.key.toString()).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {

                            val nombre = dataSnapshot.child("nombre").getValue().toString()
                            val apellido = dataSnapshot.child("apellido").getValue().toString()
                            val edad = dataSnapshot.child("edad").getValue().toString().toInt()

                            //mTextViewData.setText("El nombre es : "+nombre +" \nEl apellido es: "+apellido+" \nLa edad es: "+edad)
                            mTextViewData.append("El nombre es : "+nombre +" \nEl apellido es: "+apellido+" \nLa edad es: "+edad+"\n\n")

                            //val nombre: String = user.getNombre()
                            //val apellido: String = user.getApellido()
                            //val telefono: Int = user.getTelefono()
                            //val direccion: String = user.getDireccion()
                            //Log.e("NombreUsuario:", "" + nombre)
                            //Log.e("ApellidoUsuario:", "" + apellido)
                            //Log.e("TelefonoUsuario:", "" + telefono)
                            //Log.e("DireccionUsuario:", "" + direccion)
                            //Log.e("Datos:", "" + snapshot.value)
                        }

                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        // =========================================================
        return root
    }

}

