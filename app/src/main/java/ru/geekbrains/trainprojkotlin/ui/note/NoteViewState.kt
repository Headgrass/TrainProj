package ru.geekbrains.trainprojkotlin.ui.note

import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.ui.base.BaseViewState

class NoteViewState (note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)