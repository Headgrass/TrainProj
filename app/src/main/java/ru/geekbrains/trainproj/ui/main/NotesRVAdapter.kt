package ru.geekbrains.trainproj.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*
import ru.geekbrains.trainproj.data.entity.Note
import ru.geekbrains.trainproj.R


class NotesRVAdapter(val onItemClick: ((Note) -> Unit)? = null) : RecyclerView.Adapter<NotesRVAdapter.ViewHolder>() {

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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(note: Note) = with (itemView as CardView){
            tv_title.text = note.title
            tv_text.text = note.text

            val color = when(note.color){
                Note.Color.WHITE -> R.color.white
                Note.Color.VIOLET -> R.color.violet
                Note.Color.YELLOW -> R.color.yellow
                Note.Color.RED -> R.color.red
                Note.Color.PINK -> R.color.pink
                Note.Color.GREEN -> R.color.green
            }
            setBackgroundColor(ContextCompat.getColor(itemView.context, color))

            itemView.setOnClickListener{
                onItemClick?.invoke(note)
            }
        }
    }
}