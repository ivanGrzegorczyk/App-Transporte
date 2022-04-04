package com.frodo.apptransporte.model

class NotesManager {
    companion object {
        private val _instance = NotesManager()
        fun getManager(): NotesManager {
            return _instance
        }
    }

    private val notes = mutableListOf<Note>(
        Note("Teléfono", "1122362187"),
        Note("Dirección", "La Llama 7")
    )

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun listAll(): MutableList<Note> {
        return notes
    }
}