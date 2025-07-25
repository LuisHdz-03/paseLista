package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R

class ActualizaDatosFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actualiza_datos, container, false)

        view.findViewById<ImageButton>(R.id.btn_back)?.setOnClickListener{
            val vercredeFrag = VerCredencialFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,vercredeFrag)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}