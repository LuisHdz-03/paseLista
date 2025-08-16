package com.elmistico.paselista.ui.docente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.elmistico.paselista.R

class PerfilDocenteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil_docente, container, false)

        val perfil = Perfil("Juan Pérez", "juan@example.com", 5)

        val tvNombre = view.findViewById<TextView>(R.id.nombreDocente)
        val tvCorreo = view.findViewById<TextView>(R.id.correoDocente)
        val tvTotalGrupos = view.findViewById<TextView>(R.id.totalGrupos)

        tvNombre.text = "Nombre: ${perfil.nombre}"
        tvCorreo.text = "Correo: ${perfil.correo}"
        tvTotalGrupos.text = "Total de grupos: ${perfil.totalGrupos}"

        return view
    }
}

data class Perfil(
    val nombre: String,
    val correo: String,
    val totalGrupos: Int,
)
