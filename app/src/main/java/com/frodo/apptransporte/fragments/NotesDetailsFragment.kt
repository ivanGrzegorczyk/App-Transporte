package com.frodo.apptransporte.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.frodo.apptransporte.App
import com.frodo.apptransporte.R
import com.frodo.apptransporte.model.Note
import com.frodo.apptransporte.model.NotesManager

class NotesDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_notes_details, container, false)

        val position = arguments?.getInt("position")
        val note: Note? = NotesManager.getManager().get(position!!)

        rootView.findViewById<EditText>(R.id.editTextNoteTitle).setText(note?.title)
        rootView.findViewById<EditText>(R.id.editTextNoteBody).setText(note?.text)

        rootView.findViewById<Button>(R.id.buttonNoteSave).setOnClickListener {
            note?.title = rootView.findViewById<EditText>(R.id.editTextNoteTitle).text.toString()
            note?.text = rootView.findViewById<EditText>(R.id.editTextNoteBody).text.toString()

            findNavController().popBackStack()
        }

        rootView.findViewById<Button>(R.id.buttonNoteDelete).setOnClickListener {
            NotesManager.getManager().delete(position)
            findNavController().popBackStack()
        }

        return rootView
    }
}