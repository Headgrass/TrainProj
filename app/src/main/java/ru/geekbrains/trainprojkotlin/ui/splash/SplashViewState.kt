package ru.geekbrains.trainprojkotlin.ui.splash

import ru.geekbrains.trainprojkotlin.ui.base.BaseViewState

class SplashViewState(authenticated: Boolean? = null, error: Throwable? = null): BaseViewState<Boolean?>(authenticated, error)