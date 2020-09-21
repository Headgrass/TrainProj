package ru.geekbrains.trainproj.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.geekbrains.trainproj.data.NotesRepository
import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.data.model.NoteResult
import ru.geekbrains.trainproj.ui.base.BaseViewModel

class MainViewModel : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = Observer<NoteResult>{result ->
        result ?: return@Observer
        when(result){
            is NoteResult.Success<*> -> viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            is NoteResult.Error -> viewStateLiveData.value = MainViewState(error = result.error)
        }
    }

  private val repositoryNotes = NotesRepository.getNotes()
    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
        }

    override fun onCleared() {
        super.onCleared()
        repositoryNotes.removeObserver(notesObserver)
    }
}