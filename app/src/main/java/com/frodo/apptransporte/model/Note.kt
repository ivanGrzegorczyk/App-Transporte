package com.frodo.apptransporte.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTES")
data class Note(  // Propiedades en el constructor -> obligatorias
    var title: String,
    @ColumnInfo(name = "note_text") var text: String
) {
    // Propiedades no obligatorias
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}