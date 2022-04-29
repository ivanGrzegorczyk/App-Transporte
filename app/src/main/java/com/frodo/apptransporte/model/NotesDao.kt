package com.frodo.apptransporte.model

import androidx.room.*

@Dao
interface NotesDao {

    @Query("SELECT * FROM NOTES")
    fun getAll(): List<Note>

    @Query("SELECT * FROM NOTES WHERE id = :noteId LIMIT 1")
    fun getById(noteId: Int): Note

    @Insert
    fun insert(vararg note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM NOTES")
    fun deleteAll()

    @Update
    fun update(note: Note)
}