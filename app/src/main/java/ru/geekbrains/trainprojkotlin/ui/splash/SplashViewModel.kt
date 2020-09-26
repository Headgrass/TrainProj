package ru.geekbrains.trainprojkotlin.ui.splash

import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.errors.NoAuthException
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewModel

class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>(){

    fun requestUser(){
        NotesRepository.getCurrentUser().observeForever{
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            }else{
                SplashViewState(error = NoAuthException())
            }
        }
    }
}