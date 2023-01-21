package com.example.practica17

import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFoto : Fragment(), OnFragmentEventListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener : OnFragmentEventListener ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val imageId = requireArguments().getInt(resources.getString(R.string.image))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)

        arguments?.let {
            val idImg = requireArguments().getInt("image-id")
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setImageDrawable(context?.getDrawable(idImg))
        }
        return view
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

    override fun onFragmentEvent(nombre: String) {
        TODO("Not yet implemented")
    }
}