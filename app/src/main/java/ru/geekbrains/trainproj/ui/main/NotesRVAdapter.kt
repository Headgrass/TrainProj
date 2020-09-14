package ru.geekbrains.trainproj.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*
import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.R


class NotesRVAdapter: RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

var notes: List<Note> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
        ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
        }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int): Unit = holder.bind(notes[position])

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(note: Note){
            itemView.tv_title.text = note.title
            itemView.tv_text.text = note.text
            itemView.setBackgroundColor(note.color)
        }
    }
}