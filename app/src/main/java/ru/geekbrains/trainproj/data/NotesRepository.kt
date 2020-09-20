package ru.geekbrains.trainproj.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.geekbrains.trainproj.data.entity.Note
import java.util.*

object NotesRepository {

    private val notesLiveData = MutableLiveData<List<Note>>()

    private val notes = mutableListOf(
        Note(UUID.randomUUID().toString(),
            "Первая заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.WHITE
        ),
        Note(UUID.randomUUID().toString(),
            "Вторая заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.VIOLET
        ),
        Note(UUID.randomUUID().toString(),
            "Третья заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.YELLOW
        ),
        Note(UUID.randomUUID().toString(),
            "Четвертая заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.RED
        ),
        Note(UUID.randomUUID().toString(),
            "Пятая заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.PINK
        ),
        Note(UUID.randomUUID().toString(),
            "Шестая заметка",
            "Текст первой заметкию Не очень длинный, но интересный",
            Note.Color.GREEN
        )
    )

    init {
        notesLiveData.value = notes
    }

    fun getNotes(): LiveData<List<Note>> {
        return notesLiveData
    }

    fun saveNote(note: Note){
        addOnReplace(note)
        notesLiveData.value = notes
    }

   private fun addOnReplace(note: Note){
        for (i in 0 until notes.size ){
            if(notes[i] == note){
                notes[i] = note
                return
            }
        }
        notes.add(note)
    }
}