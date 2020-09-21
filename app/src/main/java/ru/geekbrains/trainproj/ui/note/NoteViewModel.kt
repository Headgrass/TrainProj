package ru.geekbrains.trainproj.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.geekbrains.trainproj.data.NotesRepository
import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.data.model.NoteResult
import ru.geekbrains.trainproj.ui.base.BaseViewModel
import ru.geekbrains.trainproj.ui.main.MainViewState

class NoteViewModel : BaseViewModel<Note?, NoteViewState>() {

    init {
        viewStateLiveData.value = NoteViewState()
    }

    private var pendingNote: Note? = null

    fun save(note: Note) {
        pendingNote = note
    }

    fun loadNote(noteId: String) {
        NotesRepository.getNoteById(noteId).observeForever { result ->
            result ?: return@observeForever
            when(result){
                is NoteResult.Success<*> -> viewStateLiveData.value = NoteViewState(note = result.data as? Note)
                is NoteResult.Error -> viewStateLiveData.value = NoteViewState(error = result.error)
            }
        }
    }

    override fun onCleared() {
        pendingNote?.let { NotesRepository.saveNote(it) }
    }
}