package com.elmistico.paselista.ui.alumno

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elmistico.paselista.R


class AsiAdapt(private val materias: List<AsistenciaMateria>) :
    RecyclerView.Adapter<AsiAdapt.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvmateria: TextView = view.findViewById(R.id.tv_materia)
        val tvsistencia: TextView = view.findViewById(R.id.tv_asistencias)
        val tvretardos: TextView = view.findViewById(R.id.tv_retardos)
        val tvinasistencias: TextView = view.findViewById(R.id.tv_inasistencias)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val intemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_asistencias, parent, false)
        return ViewHolder(intemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = materias[position]
        holder.tvmateria.text = "materia: ${item.materia}"
        holder.tvsistencia.text = "Asistencias ${item.asistencias}"
        holder.tvretardos.text = "Retardos: ${item.retardos}"
        holder.tvinasistencias.text = "Inasistencias ${item.inasistencias}"
    }

    override fun getItemCount(): Int = materias.size
}