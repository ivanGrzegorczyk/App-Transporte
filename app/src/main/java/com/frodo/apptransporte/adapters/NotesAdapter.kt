package com.frodo.apptransporte.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.frodo.apptransporte.R
import com.frodo.apptransporte.model.Note
import com.frodo.apptransporte.model.NotesManager

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) {
            val textTitle = itemView.findViewById<TextView>(R.id.item_note_title)
            textTitle.text = note.title
        }
    }

    var rowSelectedListener: ((Int)->Unit)? = null
    fun setOnRowSelected(listener: (Int) -> Unit) {
        rowSelectedListener = listener
    }

    // Enlaza los datos en un viewholder a partir de una posición
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = NotesManager.getManager().get(position)
        note?.let {
            holder.bind(note)
            holder.itemView.setOnClickListener {
                rowSelectedListener?.let { it(position) }
            }
            if(position % 2 == 0) {
                holder.itemView.setBackgroundColor(Color.CYAN)
            } else {
                holder.itemView.setBackgroundColor(Color.WHITE)
            }
        }
    }

    // La recyclerview me pide un viewholder vacío
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val itemNote = inflator.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemNote)
    }

    override fun getItemCount(): Int {
        return NotesManager.getManager().listAll().count()
    }
}