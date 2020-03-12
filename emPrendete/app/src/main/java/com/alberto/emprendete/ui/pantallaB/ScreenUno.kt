package com.alberto.emprendete.ui.pantallaB
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
import com.alberto.emprendete.ui.pantallaJ.ScreenNueve
import com.bumptech.glide.Glide
class ScreenUno : Fragment() {
    val utm     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Futm.jpg?alt=media&token=7f8f9692-be46-42eb-a662-c03f9ce30518"
    val itm     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Fitm.png?alt=media&token=52871b72-4da5-45ce-b9fa-ac8dfcc3beb4"
    val udm     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Fudm.png?alt=media&token=40654153-ea20-4b6d-8712-c37e41027b22"
    val uane    = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Fuane.jpg?alt=media&token=ddbf9b00-eeea-4fef-bc1a-cec1d6967199"
    val uat     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Fuat.jpg?alt=media&token=6a4c5bcd-1028-4ee7-a533-2321d4afa6a7"
    val uns     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Funs.webp?alt=media&token=c23c8814-4b89-4c77-ae21-8e2ffb561e44"
    val unm     = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/InstitucionesParticipantes%2Funiversidad%20del%20noreste%20de%20mexico.jpg?alt=media&token=e9cb1bfe-c880-4c62-a317-950a7c8ced48"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_b, container, false)

        val imgb1= root.findViewById<ImageView>(R.id.img1)
        val imgb2= root.findViewById<ImageView>(R.id.img2)
        val imgb3= root.findViewById<ImageView>(R.id.img3)
        val imgb4= root.findViewById<ImageView>(R.id.img4)
        val imgb5= root.findViewById<ImageView>(R.id.img5)
        val imgb6= root.findViewById<ImageView>(R.id.img6)
        val imgb7= root.findViewById<ImageView>(R.id.img7)

        Glide.with(this).load(utm).into(imgb1)
        Glide.with(this).load(itm).into(imgb2)
        Glide.with(this).load(udm).into(imgb3)
        Glide.with(this).load(uane).into(imgb4)
        Glide.with(this).load(uat).into(imgb5)
        Glide.with(this).load(uns).into(imgb6)
        Glide.with(this).load(unm).into(imgb7)

        //prueba para pasar datos de variable
        var institucion = ""
        val args = Bundle()
        // fin prueba pasar datos

        // codigo pasar a otro fragment
        val fragment = ScreenNueve()
        val fragmentManager = activity!!.supportFragmentManager
        // fin codigo pasar a otro fragment

        imgb1.setOnClickListener{ //utm
            Toast.makeText(activity, "tocaste imagen 1", Toast.LENGTH_LONG).show()
            institucion="utm"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb2.setOnClickListener{ //itm
            Toast.makeText(activity, "tocaste imagen 2", Toast.LENGTH_LONG).show()
            institucion="itm"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb3.setOnClickListener{ //udm
            Toast.makeText(activity, "tocaste imagen 3", Toast.LENGTH_LONG).show()
            institucion="udm"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb4.setOnClickListener{ //uane
            Toast.makeText(activity, "tocaste imagen 4", Toast.LENGTH_LONG).show()
            institucion="uane"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb5.setOnClickListener{ //uat
            Toast.makeText(activity, "tocaste imagen 5", Toast.LENGTH_LONG).show()
            institucion="uat"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb6.setOnClickListener{ //uns
            Toast.makeText(activity, "tocaste imagen 6", Toast.LENGTH_LONG).show()
            institucion="uns"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb7.setOnClickListener{ //unm
            Toast.makeText(activity, "tocaste imagen 7", Toast.LENGTH_LONG).show()
            institucion="unm"
            args.putString("escuela", institucion)
            fragment.setArguments(args)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        return root
    }
}