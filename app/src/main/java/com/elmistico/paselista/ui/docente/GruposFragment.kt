package com.elmistico.paselista.ui.docente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R

class GruposFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grupos, container, false)
        val rcview = view.findViewById<RecyclerView>(R.id.rv_grupos)
        rcview.layoutManager =LinearLayoutManager(requireContext())
        val grups = listOf(
            grupos("Sistemas 2025-1",12,8),
            grupos("Sistemas 2025-2",12,10),
            grupos("Nose 2025-2",3,1),
            grupos("Tampoco se 2025-2",30,2)
        )
        return view
    }
}

data class grupos(
    val grupo: String,
    val asistencias: Int,
    val retardos: Int,
)