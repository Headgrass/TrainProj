package ru.geekbrains.trainproj.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.trainproj.data.NotesRepository

class MainViewModel : ViewModel() {

    private val viewStateLiveData = MutableLiveData<MainViewState>()
    private val model = Model()

    init {
        NotesRepository.getNotes().observeForever {
            viewStateLiveData.value = viewStateLiveData.value?.copy(notes = it) ?: MainViewState(it)
        }
    }


    fun getViewState(): LiveData<MainViewState> = viewStateLiveData

    fun buttonClick() {
        model.riseCounter()
    }
}