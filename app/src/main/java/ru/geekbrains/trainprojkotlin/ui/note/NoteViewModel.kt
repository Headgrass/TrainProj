package ru.geekbrains.trainprojkotlin.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.model.NoteResult
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewModel
import ru.geekbrains.trainprojkotlin.ui.main.MainViewState

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