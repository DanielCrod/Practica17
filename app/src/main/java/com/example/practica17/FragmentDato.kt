package com.example.practica17

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDato : Fragment(), OnFragmentEventListener, View.OnClickListener {


    private lateinit var nombre : TextView
    private lateinit var apellidos : TextView
    private lateinit var dni : TextView
    private var listener: OnFragmentEventListener? = null
    private lateinit var  button: Button
    var alumno = Alumno()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        button = view.findViewById<Button>(R.id.boton)
        button.setOnClickListener(this)
        //Carga el texto en los TextView
        arguments?.let {
            alumno = requireArguments().getSerializable("Alumno") as Alumno

            nombre = view.findViewById<TextView>(R.id.Nombre)
            apellidos = view.findViewById<TextView>(R.id.Apellido)
            dni = view.findViewById<TextView>(R.id.Dni)

            dni.setText(alumno.DNI)
            nombre.setText(alumno.Nombre)
            apellidos.setText(alumno.Apellidos)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnFragmentEventListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.boton -> {
                listener?.let {
                    listener!!.onFragmentEvent(alumno.Nombre)
                }
            }
        }

    }

    override fun onFragmentEvent(nombre: String) {
        TODO("Not yet implemented")
    }
}