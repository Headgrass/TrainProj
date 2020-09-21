package ru.geekbrains.trainproj.data.provider

import androidx.lifecycle.LiveData
import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.data.model.NoteResult

interface DataProvider{
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
}