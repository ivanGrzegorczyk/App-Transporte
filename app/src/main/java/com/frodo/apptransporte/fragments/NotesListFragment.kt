package com.frodo.apptransporte.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frodo.apptransporte.R
import com.frodo.apptransporte.adapters.NotesAdapter
import com.frodo.apptransporte.model.NotesManager

class NotesListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_notes_list, container, false)

        rootView.findViewById<Button>(R.id.buttonAddNotes).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_notesListFragment_to_notesAddFragment)
        )

        // Configurar el RecyclerView
        val recyclerNotes = rootView.findViewById<RecyclerView>(R.id.recycklerNotes)
        recyclerNotes.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val adapter = NotesAdapter()
        recyclerNotes.adapter = adapter

        NotesManager.getManager().listAll().forEach {
            Log.d("note", it.toString())
        }
        return rootView
    }
}