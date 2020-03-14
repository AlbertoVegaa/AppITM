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
    lateinit var switcher_redes: TextSwitcher
    lateinit var siguiente:Button
    lateinit var anterior:Button
    lateinit var visor_de_datos:TextView

    var ListaNombres = arrayListOf<String>()
    var ListaBiografias = arrayListOf<String>()
    var ListaContacto = arrayListOf<String>()
    var ListaUrlFotos = arrayListOf<String>()

    var pos : Int = -1
    var indice = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.pantalla_f, container, false)
        myDatabase    = FirebaseDatabase.getInstance().reference

        //Glide.with(this).load(url).into(contenedor_imagen)

        // ======================= recibir de firebase ==================================
        myDatabase.child("mentores").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    myDatabase.child("mentores").child(snapshot.key.toString()).addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val nombre      =   dataSnapshot.child("nombre")    .getValue().toString()
                            val apellido    =   dataSnapshot.child("apellido")  .getValue().toString()
                            val biografia   =   dataSnapshot.child("bio")       .getValue().toString()
                            val foto        =   dataSnapshot.child("img")       .getValue().toString()
                            val twitter     =   dataSnapshot.child("twitter")   .getValue().toString()
                            val facebook    =   dataSnapshot.child("facebook")  .getValue().toString()
                            val youtube     =   dataSnapshot.child("youtube")   .getValue().toString()
                            val correo      =   dataSnapshot.child("email")     .getValue().toString()

                            var nombrecompleto = nombre + " " + apellido
                            var contacto = ""
                            if (facebook!="" && twitter!="" && youtube!="" && correo !=""){
                                contacto = "Correo: $correo\nFacebook: $facebook\nTwitter: $twitter\nYoutube:$youtube"
                            }
                            else{
                                if (correo!=""){
                                    contacto = contacto + "Correo: $correo\n"
                                }
                                if (facebook!=""){
                                    contacto = contacto + "Facebook: $facebook\n"
                                }
                                if (twitter!=""){
                                    contacto = contacto + "Twitter: $twitter\n"
                                }
                                if (youtube!=""){
                                    contacto = contacto + "Youtube: $youtube\n"
                                }
                            }

                            visor_de_datos = root.findViewById(R.id.text)
                            visor_de_datos.append("Nombre Completo: $nombrecompleto\nBiografia: $biografia\nFile: $foto\nContacto: $contacto\n\n")
                            visor_de_datos.setMovementMethod(ScrollingMovementMethod())

                            ListaNombres    .add(indice, nombrecompleto)
                            ListaBiografias .add(indice, biografia)
                            ListaContacto   .add(indice,contacto)
                            ListaUrlFotos   .add(indice, foto)
                            indice+=1
                        }
                        override fun onCancelled(databaseError: DatabaseError) {}
                    })
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
        Toast.makeText(activity, pos.toString(), Toast.LENGTH_SHORT).show()
        // ======================= fin de recibir de firebase ==================================

        contenedor_imagen       =       root.findViewById(R.id.imagen)
        switcher_nombres        =       root.findViewById(R.id.nombres)
        switcher_biografias     =       root.findViewById(R.id.biografia)
        switcher_redes          =       root.findViewById(R.id.contactame)
        siguiente               =       root.findViewById(R.id.siguiente)
        anterior                =       root.findViewById(R.id.anterior)
        switcher_nombres.setFactory (object : ViewSwitcher.ViewFactory {
            override fun makeView(): View {
                val textview=TextView(activity)
                textview.gravity=Gravity.CENTER
                textview.textSize=26F
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
        switcher_redes.setFactory (object : ViewSwitcher.ViewFactory {
            override fun makeView(): View {
                val textview3=TextView(activity)
                textview3.gravity=Gravity.START
                textview3.textSize=16F
                return textview3
            }
        }) // Mostrar el textbox
        siguiente.setOnClickListener {
            if (pos<ListaNombres.size-1)
            {
                pos+=1
                Toast.makeText(activity, pos.toString(), Toast.LENGTH_SHORT).show()
                Glide.with(this).load(ListaUrlFotos[pos]).into(contenedor_imagen)
                switcher_nombres.setText(ListaNombres[pos])
                switcher_biografias.setText(ListaBiografias[pos])
                switcher_redes.setText(ListaContacto[pos])
            }
        }
        anterior.setOnClickListener {
            if (pos>0)
            {
                pos -= 1
                Toast.makeText(activity, pos.toString(), Toast.LENGTH_SHORT).show()
                Glide.with(this).load(ListaUrlFotos[pos]).into(contenedor_imagen)
                switcher_nombres.setText(ListaNombres[pos])
                switcher_biografias.setText(ListaBiografias[pos])
                switcher_redes.setText(ListaContacto[pos])
            }
        }
        return root
    }
}