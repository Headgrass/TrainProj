package ru.geekbrains.trainproj.note


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import io.mockk.*
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.data.model.NoteResult
import ru.geekbrains.trainprojkotlin.ui.main.MainViewModel
import ru.geekbrains.trainprojkotlin.ui.note.NoteViewModel
import ru.geekbrains.trainprojkotlin.ui.note.NoteViewState

class NoteViewModelTest {


    @get:Rule
    val taskExecutionRule = InstantTaskExecutorRule()

    private val mockRepository = mockk<NotesRepository>()
    private val noteLiveData = MutableLiveData<NoteResult>()
    private val testNote = Note("1")

    private lateinit var viewModel: NoteViewModel

    @Before
    fun setup() {
        clearAllMocks()
        every { mockRepository.getNoteById(testNote.id) } returns noteLiveData
        every { mockRepository.deleteNote(testNote.id) } returns noteLiveData
        viewModel = NoteViewModel(mockRepository)
    }


    @Test
    fun `loadNote should return Note`() {
        var result: NoteViewState.Data? = null
        var testData = NoteViewState.Data(false, testNote)
        viewModel.getViewState().observeForever {
            result = it?.data
        }
        viewModel.loadNote(testNote.id)
        noteLiveData.value = NoteResult.Success(testNote)
        assertEquals(testData, result)
    }
    @Test
    fun `loadNote should return error`() {
        var result: Throwable? = null
        var testData = Throwable("error")
        viewModel.getViewState().observeForever {
            result = it?.error
        }
        viewModel.loadNote(testNote.id)
        noteLiveData.value = NoteResult.Error(error = testData)
        assertEquals(testData, result)
    }
    @Test
    fun `delete should return NoteData with isDeleted`() {
        var result: NoteViewState.Data? = null
        var testData = NoteViewState.Data(true, null)
        viewModel.getViewState().observeForever {
            result = it?.data
        }
        viewModel.save(testNote)
        viewModel.deleteNote()
        noteLiveData.value = NoteResult.Success(null)
        assertEquals(testData, result)
    }
    @Test
    fun `delete should return error`() {
        var result: Throwable? = null
        var testData = Throwable("error")
        viewModel.getViewState().observeForever {
            result = it?.error
        }
        viewModel.save(testNote)
        viewModel.deleteNote()
        noteLiveData.value = NoteResult.Error(error = testData)
        assertEquals(testData, result)
    }

}