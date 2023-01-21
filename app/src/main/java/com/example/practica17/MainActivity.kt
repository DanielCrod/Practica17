package com.example.practica17


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener, OnFragmentEventListener {
    private lateinit var ArrayAlumnos :ArrayList<Alumno>
    private lateinit var btnDatos : Button
    private lateinit var btnFoto : Button
    private lateinit var  txtView : TextView
    private lateinit var  spinner : Spinner
    private var listener : OnFragmentEventListener ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayAlumnos=ArrayList()
        btnDatos =findViewById(R.id.datos)
        btnFoto = findViewById(R.id.fotos)
        txtView = findViewById(R.id.txtview)
        spinner = findViewById(R.id.spinner)

        val a1 = Alumno("Pepe", "Hernández ", "71205721K", R.drawable.chico1)
        val a2 = Alumno("Antonio", " Rodríguez", "54846584O", R.drawable.chica1)
        val a3 = Alumno("Miguel", " Barajas", "854120525T", R.drawable.chico2)
        val a4 = Alumno("Jose", "Joselez", "76241589I", R.drawable.chica2)


        ArrayAlumnos.add(a1)
        ArrayAlumnos.add(a2)
        ArrayAlumnos.add(a3)
        ArrayAlumnos.add(a4)

        val adaptadorAlumnos = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, ArrayAlumnos)
        spinner.adapter = adaptadorAlumnos

        btnDatos.setOnClickListener(this)
        btnFoto.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.datos ->{
                val bundle = Bundle()
                val alumno = spinner.selectedItem as Alumno

                val fragmentManager = supportFragmentManager

                /*Crear una transaccion*/
                val fragmentTransaction = fragmentManager.beginTransaction()
                /*Crear una instancia del fragmento a cargar*/
                var miFragmento = FragmentDato()
                bundle.putSerializable("Alumno",alumno)
                miFragmento.arguments=bundle

                fragmentTransaction.replace(R.id.fragment, miFragmento)
                fragmentTransaction.addToBackStack(null)

                fragmentTransaction.commit()
            }
            R.id.fotos ->{
                val bundle = Bundle()
                val alumno = spinner.selectedItem as Alumno
                val fragmentManager = supportFragmentManager
                /*Crear una transaccion*/
                val fragmentTransaction = fragmentManager.beginTransaction()
                /*Crear una instancia del fragmento a cargar*/
                var miFragmento: Fragment? = null

                miFragmento = FragmentFoto()
                bundle.putInt("image-id",alumno.idimage)
                miFragmento.arguments=bundle
                fragmentTransaction.replace(R.id.fragment, miFragmento)
                fragmentTransaction.addToBackStack(null)

                fragmentTransaction.commit()
            }


        }
    }

    override fun onFragmentEvent(nombre: String) {
        txtView.setText(nombre)
    }


}