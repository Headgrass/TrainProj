package ru.geekbrains.trainprojkotlin.data.provider

import androidx.lifecycle.LiveData
import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.entity.User
import ru.geekbrains.trainprojkotlin.data.model.NoteResult

interface DataProvider{
    fun getCurrentUser() : LiveData<User?>
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
    fun deleteNote(id: String) : LiveData<NoteResult>
}