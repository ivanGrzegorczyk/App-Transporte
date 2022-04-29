package com.frodo.apptransporte.model

import androidx.room.Room
import com.frodo.apptransporte.App

class NotesManager {
    companion object {
        private val _instance = NotesManager()
        fun getManager(): NotesManager {
            return _instance
        }
    }

    private var notes = mutableListOf<Note>()
    private var db: AppDatabase = Room.databaseBuilder(
        App.context,
        AppDatabase::class.java,
        "transporte"
    ).allowMainThreadQueries().build()

    init {
        notes = db.notesDao().getAll().toMutableList()
    }

    private val listeners = mutableListOf<()->Unit>()
    fun registerListener(listener: ()->Unit) {
        listeners.add(listener)
    }

    fun addNote(note: Note) {
        notes.add(note)
        listeners.forEach { it.invoke() }
        // Actualizar la DB
        db.notesDao().insert(note)
    }

    fun listAll(): MutableList<Note> {
        return notes
    }

    fun get(i: Int): Note? {
        return if (i >= 0) {
            notes[i]
        } else {
            return null
        }
    }

    fun delete(i : Int) {
        this.get(i)?.let { db.notesDao().delete(it) }
        notes.removeAt(i)
    }
}