package com.elmistico.paselista.ui.docente

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R

class Adapt(private val grupos: List<grupos>) :
    RecyclerView.Adapter<Adapt.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvgrupos: TextView = view.findViewById(R.id.tv_grupos)
        val tvasistencia: TextView = view.findViewById(R.id.tv_asistenciasTotales)
        val tvfaltas: TextView = view.findViewById(R.id.tv_faltasTotales)
    }
}