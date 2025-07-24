package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R

class homeFragment : Fragment() {

    data class AlumnoInfo(
        val nombre: String,
        val matricula: String,
        val periodo: String,
        val asistencias: Int,
        val retardos: Int,
        val inasistencias: Int,
        val tareasAsignadas: Int,
        val tareasNoEntregadas: Int,
        val incidenciasMenores: Int,
        val incidenciasMayores: Int
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Simulación de datos que vendrían de una API
        val alumno = AlumnoInfo(
            nombre = "Albertano Santa Cruz",
            matricula = "21040497",
            periodo = "2025-1",
            asistencias = 17,
            retardos = 2,
            inasistencias = 1,
            tareasAsignadas = 8,
            tareasNoEntregadas = 4,
            incidenciasMenores = 1,
            incidenciasMayores = 0
        )

        // Referenciar TextViews y mostrar datos simulados
        view.findViewById<TextView>(R.id.tv_nombre).text = "Nombre: ${alumno.nombre}"
        view.findViewById<TextView>(R.id.tv_matricula).text = "Matrícula: ${alumno.matricula}"
        view.findViewById<TextView>(R.id.tv_periodo).text = "Periodo: ${alumno.periodo}"

        view.findViewById<TextView>(R.id.tv_asistencias).text = "Asistencias: ${alumno.asistencias}"
        view.findViewById<TextView>(R.id.tv_retardos).text = "Retardos: ${alumno.retardos}"
        view.findViewById<TextView>(R.id.tv_inasistencias).text = "Inasistencias: ${alumno.inasistencias}"

        view.findViewById<TextView>(R.id.tv_asignadasT).text = "Tareas asignadas: ${alumno.tareasAsignadas}"
        view.findViewById<TextView>(R.id.tv_faltasT).text = "Tareas no entregadas: ${alumno.tareasNoEntregadas}"

        view.findViewById<TextView>(R.id.tv_incidenciasMin).text = "Incidencias menores: ${alumno.incidenciasMenores}"
        view.findViewById<TextView>(R.id.tv_incidenciasM).text = "Incidencias mayores: ${alumno.incidenciasMayores}"

        // Imagen de QR
        view.findViewById<ImageView>(R.id.image_qr).setImageResource(R.drawable.ic_qr_placeholder)

        return view
    }
}