package ru.geekbrains.trainprojkotlin.data

import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.provider.DataProvider
import ru.geekbrains.trainprojkotlin.data.provider.FirestoreProvider

object NotesRepository {

    private val DataProvider: DataProvider =
        FirestoreProvider()

    fun getCurrentUser() = DataProvider.getCurrentUser()
    fun getNotes() = DataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = DataProvider.saveNote(note)
    fun getNoteById(id: String) = DataProvider.getNoteById(id)

}