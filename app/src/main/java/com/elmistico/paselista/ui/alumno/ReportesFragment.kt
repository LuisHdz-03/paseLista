package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R


data class incidencia(
    val tipo: String,
    val fecha: String,
    val docente: String,
    val descripcion: String,
)

class ReportesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reportes, container, false)
        val rcview = view.findViewById<RecyclerView>(R.id.rv_reportes)
        rcview.layoutManager = LinearLayoutManager(requireContext())
        val incidencias = listOf(
            incidencia("Falta Justificada", "2025-07-10", "Alex Tremo", "Enfermedad"),
            incidencia("Retardo", "2025-07-12", "Anita la huerfanita", "Llegó tarde por tráfico"),
            incidencia("Ausencia", "2025-07-15", "Melquiades ", "Evento familiar")
        )
        rcview.adapter = repAdapt(incidencias)

        return view
    }
}