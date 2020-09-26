package ru.geekbrains.trainprojkotlin.ui.main

import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)