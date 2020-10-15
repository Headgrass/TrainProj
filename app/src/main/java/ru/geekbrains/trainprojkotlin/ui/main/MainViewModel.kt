package ru.geekbrains.trainprojkotlin.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.model.NoteResult
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewModel

class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = Observer<NoteResult>{result ->
        result ?: return@Observer
        when(result){
            is NoteResult.Success<*> -> viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            is NoteResult.Error -> viewStateLiveData.value = MainViewState(error = result.error)
        }
    }

  private val repositoryNotes = notesRepository.getNotes()
    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
        }

    @VisibleForTesting
    public override fun onCleared() {
        super.onCleared()
        repositoryNotes.removeObserver(notesObserver)
    }
}