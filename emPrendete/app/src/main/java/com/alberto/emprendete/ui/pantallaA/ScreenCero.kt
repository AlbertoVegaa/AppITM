@file:Suppress("DEPRECATION")

package com.alberto.emprendete.ui.pantallaA

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
import com.google.firebase.database.*

class ScreenCero : Fragment() {
    private lateinit var mTextViewData: TextView
    private lateinit var myDatabase: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
/*
        // ====================================== verificar conexion a internet ===========================================================
        val mgr = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = mgr.activeNetworkInfo
        if (netInfo != null) {
            if (netInfo.isConnected()) {
                Toast.makeText(activity, "Conectado", Toast.LENGTH_SHORT).show()
                }
            else {
                Toast.makeText(activity, "No 1 Conectado", Toast.LENGTH_SHORT).show()
                val mAlertDialogBuilder = AlertDialog.Builder(activity)
                mAlertDialogBuilder.setTitle("Necesitas estar Conectado a internet")
                mAlertDialogBuilder.setIcon(R.drawable.icon_about)
                mAlertDialogBuilder.setMessage("No estas conectado a internet,\nverifica tu conexion")
                mAlertDialogBuilder.setCancelable(false)
                mAlertDialogBuilder.setPositiveButton("Salir"){_,_->activity?.finish()}
                val mAlertDialog=mAlertDialogBuilder.create()
                mAlertDialog.show()

                }
            }
        else {
            Toast.makeText(activity, "No 2 Conectado", Toast.LENGTH_SHORT).show()

            val mAlertDialogBuilder = AlertDialog.Builder(activity)
            mAlertDialogBuilder.setTitle("Necesitas estar Conectado a internet")
            mAlertDialogBuilder.setIcon(R.drawable.icon_about)
            mAlertDialogBuilder.setMessage("No estas conectado a internet,\nverifica tu conexion")
            mAlertDialogBuilder.setCancelable(false)
            mAlertDialogBuilder.setPositiveButton("Salir"){_,_->activity?.finish()}
            val mAlertDialog=mAlertDialogBuilder.create()
            mAlertDialog.show()
        }
        // ==================================== fin de verificacion de internet ===========================================================
*/
        val root = inflater.inflate(R.layout.pantalla_a, container, false)
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