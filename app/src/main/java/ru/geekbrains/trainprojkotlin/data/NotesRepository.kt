package ru.geekbrains.trainprojkotlin.data

import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.provider.DataProvider

class NotesRepository(val dataProvider: DataProvider) {

    fun getCurrentUser() = dataProvider.getCurrentUser()
    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)
    fun deleteNote(id: String) = dataProvider.deleteNote(id)

}