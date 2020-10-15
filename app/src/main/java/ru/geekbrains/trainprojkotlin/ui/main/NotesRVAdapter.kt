package ru.geekbrains.trainprojkotlin.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_note.view.*
import ru.geekbrains.trainprojkotlin.data.entity.Note
import ru.geekbrains.trainprojkotlin.R
import ru.geekbrains.trainprojkotlin.extensions.getColorInt


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

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(note: Note) = with (itemView as CardView){
            tv_title.text = note.title
            tv_text.text = note.text

            setBackgroundColor(note.color.getColorInt(context))

            itemView.setOnClickListener{
                onItemClick?.invoke(note)
            }
        }
    }
}