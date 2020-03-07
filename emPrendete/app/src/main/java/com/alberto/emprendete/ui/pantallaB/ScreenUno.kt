package com.alberto.emprendete.ui.pantallaB
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
import com.alberto.emprendete.ui.pantallaJ.ScreenNueve
import com.bumptech.glide.Glide
class ScreenUno : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.pantalla_b, container, false)

        val saludo = root.findViewById<TextView>(R.id.saludito)
        saludo.text = "Bienvenidos al evento de emprendimiento mas importante de Tamaulipas"
        saludo.setSingleLine()
        saludo.ellipsize=TextUtils.TruncateAt.MARQUEE
        saludo.marqueeRepeatLimit = -1
        saludo.isSelected=true

        val imgb1= root.findViewById<ImageView>(R.id.img1)
        val imgb2= root.findViewById<ImageView>(R.id.img2)
        val imgb3= root.findViewById<ImageView>(R.id.img3)
        val imgb4= root.findViewById<ImageView>(R.id.img4)
        val imgb5= root.findViewById<ImageView>(R.id.img5)
        val imgb6= root.findViewById<ImageView>(R.id.img6)
        val imgb7= root.findViewById<ImageView>(R.id.img7)

        val utm = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/utm.jpg?alt=media&token=407b39d5-61fa-43e1-8b19-3f1678b19bab"
        Glide.with(this).load(utm).into(imgb1)
        val itm = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/itm.png?alt=media&token=56590a7e-11b5-4216-8d69-87cdd2ecc6f9"
        Glide.with(this).load(itm).into(imgb2)
        val udm = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/udm.png?alt=media&token=7aa2a7b2-fda5-45b4-a1a6-0450af19f070"
        Glide.with(this).load(udm).into(imgb3)
        val uane = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/uane.jpg?alt=media&token=47a59eae-10e0-4d82-9a73-f7f45c0e4ea4"
        Glide.with(this).load(uane).into(imgb4)
        val uat= "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/uat.jpg?alt=media&token=b322007b-bcb0-4f0c-95b9-a2c2ccef37d8"
        Glide.with(this).load(uat).into(imgb5)
        val uns= "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/uns.webp?alt=media&token=7af0fcbd-06c4-41cc-b146-53ed8c0cc1d1"
        Glide.with(this).load(uns).into(imgb6)
        val unm= "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/universidad%20del%20noreste%20de%20mexico.jpg?alt=media&token=8c3dbcc8-4a60-4512-97ed-7c175ed1b0b8"
        Glide.with(this).load(unm).into(imgb7)

        imgb1.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 1", Toast.LENGTH_LONG).show()
            val fragment = ScreenNueve()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.broot, fragment)
            fragmentTransaction.commit()
        }
        imgb2.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 2", Toast.LENGTH_LONG).show()
        }
        imgb3.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 3", Toast.LENGTH_LONG).show()
        }
        imgb4.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 4", Toast.LENGTH_LONG).show()
        }
        imgb5.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 5", Toast.LENGTH_LONG).show()
        }
        imgb6.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 6", Toast.LENGTH_LONG).show()
        }
        imgb7.setOnClickListener{
            Toast.makeText(activity, "tocaste imagen 7", Toast.LENGTH_LONG).show()
        }
        return root
    }
}