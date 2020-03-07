package com.alberto.emprendete.ui.pantallaF
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.alberto.emprendete.R
import com.bumptech.glide.Glide
import com.google.firebase.database.*
class ScreenCinco : Fragment() {

    private lateinit var myDatabase: DatabaseReference
    private lateinit var contenedor_imagen: ImageView
    lateinit var switcher_nombres: TextSwitcher
    lateinit var switcher_biografias: TextSwitcher
    lateinit var siguiente:Button
    lateinit var anterior:Button
    lateinit var visor_de_datos:TextView

    var url1 = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/yo.png?alt=media&token=f58966d7-9a4a-44be-96c1-7924c1e10c5e"
    var url2 = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/universidad%20del%20noreste%20de%20mexico.jpg?alt=media&token=8c3dbcc8-4a60-4512-97ed-7c175ed1b0b8"
    var url3 = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/udm.png?alt=media&token=7aa2a7b2-fda5-45b4-a1a6-0450af19f070"
    val nombres_fic = arrayOf("nombre 1","nombre 2", "nombre 3", "nombre 4", "nombre 5", "nombre 6", "nombre 7")
    val biografias_fic = arrayOf("biografia 1","biografia 2", "biografia 3", "biografia 4", "biografia 5", "biografia 6", "biografia 7")
    val fotos_url = arrayOf(url1,url2,url3,url1,url2,url3,url1)

    // ================= Prueba con datos de firebase en Arrays Vacios ==============================
    //val arrayNombres = arrayOf<String>()
    //val arrayBiografias = arrayOf<String>()
    //val arrayFotos = arrayOf<String>()
    // ================================== fin de pruebas =====================================

    var pos : Int = -1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val root = inflater.inflate(R.layout.pantalla_f, container, false)
        myDatabase = FirebaseDatabase.getInstance().reference

        // Establecer imagen
        //var url = "https://firebasestorage.googleapis.com/v0/b/emprendete-842ea.appspot.com/o/yo.png?alt=media&token=f58966d7-9a4a-44be-96c1-7924c1e10c5e"
        //Glide.with(this).load(url).into(contenedor_imagen)
        // Fin de establecer imagen

        // ======================= recibir de firebase ==================================
        myDatabase.child("mentores").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {

                    myDatabase.child("mentores").child(snapshot.key.toString()).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val nombre =    dataSnapshot.child("nombre")    .getValue().toString()
                            val apellido =  dataSnapshot.child("apellido")  .getValue().toString()
                            val biografia = dataSnapshot.child("bio")       .getValue().toString()
                            val email =     dataSnapshot.child("email")     .getValue().toString()
                            val facebook =  dataSnapshot.child("facebook")  .getValue().toString()
                            val twitter =   dataSnapshot.child("twitter")   .getValue().toString()
                            val youtube =   dataSnapshot.child("youtube")   .getValue().toString()
                            val foto    =   dataSnapshot.child("url")       .getValue().toString()
                            //obtencion de un numero de firebase val edad = dataSnapshot.child("edad").getValue().toString().toInt()
                            visor_de_datos = root.findViewById(R.id.text)
                            visor_de_datos.append("El nombre es: "+nombre+" \nEl apellido es: "+apellido+" \nBiografia: "+biografia+"\nEmail: "+email+"\nFacebook: "+facebook+"\nTwitter: "+twitter+"\nYoutube: "+youtube+"\nFoto: "+foto+"\n\n")
                            visor_de_datos.setMovementMethod(ScrollingMovementMethod())
                        }
                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
        // ======================= fin de recibir de firebase ==================================

        contenedor_imagen       =       root.findViewById(R.id.imagen)
        switcher_nombres        =       root.findViewById(R.id.textswitcher)
        switcher_biografias     =       root.findViewById(R.id.biografia)
        siguiente               =       root.findViewById(R.id.siguiente)
        anterior                =       root.findViewById(R.id.anterior)

        switcher_nombres.setFactory (object : ViewSwitcher.ViewFactory {
            override fun makeView(): View {
                val textview=TextView(activity)
                textview.gravity=Gravity.CENTER
                textview.textSize=22F
                return textview
            }
        }) // Mostrar el textbox
        switcher_biografias.setFactory (object : ViewSwitcher.ViewFactory {
            override fun makeView(): View {
                val textview2=TextView(activity)
                textview2.textSize=18F
                textview2.gravity=Gravity.START
                return textview2
            }
        }) // Mostrar el textbox

        anterior.setOnClickListener {
            if (pos>0)
            {pos-=1
                Glide.with(this).load(fotos_url[pos]).into(contenedor_imagen)
                switcher_nombres.setText(nombres_fic[pos])
                switcher_biografias.setText(biografias_fic[pos])
            }
        }
        siguiente.setOnClickListener {
            if (pos<nombres_fic.size-1)
            {
                pos+=1
                Glide.with(this).load(fotos_url[pos]).into(contenedor_imagen)
                switcher_nombres.setText(nombres_fic[pos])
                switcher_biografias.setText(biografias_fic[pos])
            }
        }
        return root
    }
}