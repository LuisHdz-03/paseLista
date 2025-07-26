package com.elmistico.paselista.ui.alumno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R

class VerCredencialFragment : Fragment() {
    data class AlumnoInfo(
        val nombre: String,
        val matricula: String,
        val periodo: String,
        val grupo: String,
        val Tutor: String,
        val Vigencia: String,
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ver_credencial, container, false)

        val alumno = AlumnoInfo(
            nombre = "Albertano Santa Cruz",
            matricula = "21040497",
            periodo = "2025-1",
            grupo = "9°A Sistemas",
            Tutor = "Armando Bronca",
            Vigencia = "Semestre 2025-2, del 18 de agosto al 9 de diciembre de 2025."
        )
        view.findViewById<TextView>(R.id.tv_nombre).text = "Nombre:\n${alumno.nombre}"
        view.findViewById<TextView>(R.id.tv_matricula).text = "Matrícula:\n${alumno.matricula}"
        view.findViewById<TextView>(R.id.tv_periodo).text = "Periodo:\n${alumno.periodo}"
        view.findViewById<TextView>(R.id.tv_grupo).text = "Grupo:\n${alumno.grupo}"
        view.findViewById<TextView>(R.id.tv_tutor).text = "Tutor:\n${alumno.Tutor}"
        view.findViewById<TextView>(R.id.tv_vigencia).text = "Vigencia:\n${alumno.Vigencia}"

        view.findViewById<Button>(R.id.btn_actualizar)?.setOnClickListener{
            val actualizarFragment = ActualizaDatosFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, actualizarFragment)
                .addToBackStack(null)
                .commit()

        }

        return view
    }
}
