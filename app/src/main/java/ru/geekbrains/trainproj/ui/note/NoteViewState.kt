package ru.geekbrains.trainproj.ui.note

import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.ui.base.BaseViewState

class NoteViewState (note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)