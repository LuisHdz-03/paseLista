package com.elmistico.paselista.ui.docente

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grupos, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = grupos[position]
        holder.tvgrupos.text = "Grupo: ${item.grupo}"
        holder.tvasistencia.text = "Total: ${item.asistencias}"
        holder.tvfaltas.text = "Total: ${item.retardos}"
    }

    override fun getItemCount(): Int = grupos.size
}