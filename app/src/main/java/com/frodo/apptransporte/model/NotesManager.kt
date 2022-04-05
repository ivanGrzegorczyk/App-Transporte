package com.frodo.apptransporte.model

class NotesManager {
    companion object {
        private val instance = NotesManager()
        fun getManager(): NotesManager {
            return instance
        }
    }

    private val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun listAll(): MutableList<Note> {
        return notes
    }

    fun get(i: Int): Note? {
        return if(i >= 0) {
            notes[i]
        } else {
            null
        }
    }
}