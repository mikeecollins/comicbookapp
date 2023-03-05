package ie.setu.comicbookapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.setu.comicbookapp.databinding.CardComicbookBinding
import ie.setu.comicbookapp.models.ComicbookModel


interface ComicbookListener {
    fun onComicbookClick(comicbook: ComicbookModel)
}

class ComicbookAdapter(private var comicbooks: ArrayList<ComicbookModel>,
                       private val listener: ComicbookListener) :


    RecyclerView.Adapter<ComicbookAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardComicbookBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val comicbook = comicbooks[holder.adapterPosition]
        holder.bind(comicbook, listener)
    }

    override fun getItemCount(): Int = comicbooks.size

    class MainHolder(private val binding : CardComicbookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comicbook: ComicbookModel, listener: ComicbookListener) {
            binding.comicbookTitle.text = comicbook.title
            binding.description.text = comicbook.description
            binding.root.setOnClickListener { listener.onComicbookClick(comicbook) }
        }
        }
    }
