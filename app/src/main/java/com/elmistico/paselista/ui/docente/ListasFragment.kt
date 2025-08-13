package com.elmistico.paselista.ui.docente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R

class ListasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listas, container, false)
        val rcview = view.findViewById<RecyclerView>(R.id.rv_listas)

        val grupos = listOf(
            Grupo(
                grupNombre = "3A",
                periodo = "2025-2",
                materia = "programacion",
                alumnos = listOf(
                    Alumno("Montesuma"),
                    Alumno("Alquimedes"),
                    Alumno("Nepomuseno")
                )
            ),
            Grupo(
                grupNombre = "9A",
                periodo = "2025-2",
                materia = "nose",
                alumnos = listOf(
                    Alumno("Montesuma uno"),
                    Alumno("Alquimedes dos"),
                    Alumno("Nepomuseno tres")
                )
            )
        )

        val items: MutableList<ItemLista> = grupos.map { ItemLista.GrupoItem(it) }.toMutableList()
        val adapter = GrupoAdapter(items)
        rcview.layoutManager = LinearLayoutManager(requireContext())
        rcview.adapter = adapter

        return view
    }
}

data class Alumno(
    val nombre: String
)

data class Grupo(
    val grupNombre: String,
    val periodo: String,
    val materia: String,
    val alumnos: List<Alumno>,
    var expandido: Boolean = false
)