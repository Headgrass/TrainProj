package ru.geekbrains.trainproj.data

import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.data.provider.DataProvider
import ru.geekbrains.trainproj.data.provider.FirestoreProvider

object NotesRepository {

    private val DataProvider: DataProvider = FirestoreProvider()

    fun getNotes() = DataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = DataProvider.saveNote(note)
    fun getNoteById(id: String) = DataProvider.getNoteById(id)

}