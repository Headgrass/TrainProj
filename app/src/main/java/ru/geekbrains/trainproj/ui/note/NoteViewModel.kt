package ru.geekbrains.trainproj.ui.note

import androidx.lifecycle.ViewModel
import ru.geekbrains.trainproj.data.NotesRepository
import ru.geekbrains.trainproj.data.entity.Note

class NoteViewModel : ViewModel() {

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        pendingNote?.let { NotesRepository.saveNote(it) }
    }
}