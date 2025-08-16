package com.elmistico.paselista.ui.docente

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

private const val TYPE_GRUPO = 0
private const val TYPE_ALUMNO = 1
private const val TYPE_FOOTER = 2

sealed class ItemLista {
    data class GrupoItem(val grupo: Grupo) : ItemLista()
    data class AlumnoItem(val alumno: Alumno) : ItemLista()
    data class FooterItem(val grupo: Grupo) : ItemLista()
}


class GrupoAdapter(
    private val items: MutableList<ItemLista>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class GrupoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textGrupo: TextView = itemView.findViewById(R.id.textGrupo)
        val textPeriodo: TextView = itemView.findViewById(R.id.textPeriodo)
        val textMateria: TextView = itemView.findViewById(R.id.textMateria)
        val textToggle: TextView = itemView.findViewById(R.id.textToggle)
    }

    inner class AlumnoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreAlumno: TextView = itemView.findViewById(R.id.nombreAlumno)
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnTomarLista: Button = itemView.findViewById(R.id.btnTomarLista)
        val btnPDF: Button = itemView.findViewById(R.id.btnGenerarPDF)
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemLista.GrupoItem -> TYPE_GRUPO
            is ItemLista.AlumnoItem -> TYPE_ALUMNO
            is ItemLista.FooterItem -> TYPE_FOOTER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_GRUPO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_grupo, parent, false)
                GrupoViewHolder(view)
            }

            TYPE_ALUMNO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_alumnos, parent, false)
                AlumnoViewHolder(view)
            }

            TYPE_FOOTER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_botones_alumnos, parent, false)
                FooterViewHolder(view)
            }

            else -> throw IllegalArgumentException("Tipo no soportado")
        }
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItemLista.GrupoItem -> {
                val grupoHolder = holder as GrupoViewHolder
                val grupo = item.grupo
                grupoHolder.textGrupo.text = "Grupo: ${grupo.grupNombre}"
                grupoHolder.textPeriodo.text = "Periodo: ${grupo.periodo}"
                grupoHolder.textMateria.text = "Materia: ${grupo.materia}"
                grupoHolder.textToggle.text =
                    if (grupo.expandido) "🔼 Ocultar alumnos" else "🔽 Ver alumnos"

                grupoHolder.textToggle.setOnClickListener {
                    val pos = holder.adapterPosition
                    if (grupo.expandido) {
                        collapseAlumnos(pos, grupo)
                    } else {
                        expandAlumnos(pos, grupo)
                    }
                    grupo.expandido = !grupo.expandido
                    notifyItemChanged(pos)
                }
            }

            is ItemLista.AlumnoItem -> {
                val alumnoHolder = holder as AlumnoViewHolder
                alumnoHolder.nombreAlumno.text = "👤 ${item.alumno.nombre}"
            }

            is ItemLista.FooterItem -> {
                val footerHolder = holder as FooterViewHolder
                footerHolder.btnTomarLista.setOnClickListener {
                    //ps aqui se pone la accion xd
                }
                footerHolder.btnPDF.setOnClickListener {
                    //aqui igual xd
                }
            }
        }
    }

    private fun expandAlumnos(position: Int, grupo: Grupo) {
        val alumnos = grupo.alumnos.map { ItemLista.AlumnoItem(it) }
        val footer = ItemLista.FooterItem(grupo)

        items.addAll(position + 1, alumnos + footer)
        notifyItemRangeInserted(position + 1, alumnos.size)
    }

    private fun collapseAlumnos(position: Int, grupo: Grupo) {
        val count = grupo.alumnos.size + 1
        items.subList(position + 1, position + 1 + count).clear()
        notifyItemRangeRemoved(position + 1, count)
    }
}


