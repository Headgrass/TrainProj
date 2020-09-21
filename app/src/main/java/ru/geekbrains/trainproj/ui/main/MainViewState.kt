package ru.geekbrains.trainproj.ui.main

import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.ui.base.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)