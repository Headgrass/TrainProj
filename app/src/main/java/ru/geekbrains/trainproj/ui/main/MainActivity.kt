package ru.geekbrains.trainproj.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.geekbrains.trainproj.R
import ru.geekbrains.trainproj.ui.main.MainViewModel
import ru.geekbrains.trainproj.ui.main.NotesRVAdapter
import ru.geekbrains.trainproj.ui.note.NoteActivity

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NotesRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        adapter = NotesRVAdapter{
            NoteActivity.start(this, it)
        }
        rv_notes.adapter = adapter

        viewModel.getViewState().observe(this, Observer { value ->
            value?.let { adapter.notes = it.notes }
        })

        fab.setOnClickListener {
            NoteActivity.start(this)
        }
    }
}
