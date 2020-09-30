package ru.geekbrains.trainprojkotlin.ui.splash

import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.errors.NoAuthException
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewModel

class SplashViewModel(val notesRepository: NotesRepository) : BaseViewModel<Boolean?, SplashViewState>(){

    fun requestUser(){
        notesRepository.getCurrentUser().observeForever{
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            }else{
                SplashViewState(error = NoAuthException())
            }
        }
    }
}