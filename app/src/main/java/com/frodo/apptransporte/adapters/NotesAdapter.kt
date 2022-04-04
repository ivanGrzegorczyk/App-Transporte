package com.frodo.apptransporte.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frodo.apptransporte.model.NotesManager

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val textView: TextView = holder.itemView as TextView
        textView.text = NotesManager.getManager().listAll()[position].title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return NotesManager.getManager().listAll().count()
    }
}