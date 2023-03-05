package ie.setu.comicbookapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.setu.comicbookapp.R
import ie.setu.comicbookapp.databinding.ActivityComicbookListBinding
import ie.setu.comicbookapp.databinding.CardComicbookBinding
import ie.setu.comicbookapp.main.MainApp
import ie.setu.comicbookapp.models.ComicbookModel

class ComicbookListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityComicbookListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comicbook_list)

        app = application as MainApp


        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = ComicbookAdapter(app.comicbooks)
    }
}

class ComicbookAdapter constructor(private var comicbooks: List<ComicbookModel>) :
    RecyclerView.Adapter<ComicbookAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardComicbookBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val comicbook = comicbooks[holder.adapterPosition]
        holder.bind(comicbook)
    }

    override fun getItemCount(): Int = comicbooks.size

    class MainHolder(private val binding : CardComicbookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comicbook: ComicbookModel) {
            binding.comicbookTitle.text = comicbook.title
            binding.description.text = comicbook.description
        }
    }
}
