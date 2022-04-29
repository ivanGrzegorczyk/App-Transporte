package com.frodo.apptransporte.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.frodo.apptransporte.R
import com.frodo.apptransporte.model.Note
import com.frodo.apptransporte.model.NotesManager

class NotesAddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_notes_add, container, false)

        rootView.findViewById<Button>(R.id.buttonNoteSave).setOnClickListener {
            val noteTitle: String = rootView.findViewById<EditText>(R.id.editTextNoteTitle).text.toString()
            val noteBody: String = rootView.findViewById<EditText>(R.id.editTextNoteBody).text.toString()

            if(noteTitle.isNotBlank() || noteBody.isNotBlank()) {
                NotesManager.getManager().addNote(Note(noteTitle, noteBody))
            }
            findNavController().popBackStack()
        }

        rootView.findViewById<Button>(R.id.buttonNoteCancel).setOnClickListener {
            findNavController().popBackStack()
        }

        return rootView
    }
}