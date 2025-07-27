package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R

data class AsistenciaMateria(
    val materia: String,
    val asistencias: Int,
    val retardos: Int,
    val inasistencias: Int
)

class asistenciasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_asistencias, container, false)

        val rcview = view.findViewById<RecyclerView>(R.id.rv_asistencias)
        rcview.layoutManager = LinearLayoutManager(requireContext())
        val materias = listOf(
            AsistenciaMateria("Programacion", 19, 2, 2),
            AsistenciaMateria("Física", 18, 2, 4),
            AsistenciaMateria("Programación", 22, 1, 1)
        )
        rcview.adapter = AsiAdapt(materias)

        return view
    }
}