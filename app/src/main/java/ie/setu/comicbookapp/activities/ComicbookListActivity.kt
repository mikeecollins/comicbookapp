package ie.setu.comicbookapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import ie.setu.comicbookapp.R
import ie.setu.comicbookapp.adapters.ComicbookAdapter
import ie.setu.comicbookapp.adapters.ComicbookListener
import ie.setu.comicbookapp.databinding.ActivityComicbookListBinding
import ie.setu.comicbookapp.main.MainApp
import ie.setu.comicbookapp.models.ComicbookModel

class ComicbookListActivity : AppCompatActivity(), ComicbookListener {


    lateinit var app: MainApp
    private lateinit var binding: ActivityComicbookListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicbookListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)


        app = application as MainApp


        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
      //  binding.recyclerView.adapter = ComicbookAdapter(app.comicbooks)
        binding.recyclerView.adapter = ComicbookAdapter(app.comicbooks.findAll() as ArrayList<ComicbookModel>,this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.item_add -> {
            val launcherIntent = Intent(this, ComicbookActivity::class.java)
            getResult.launch(launcherIntent)
        }
    }
    return super.onOptionsItemSelected(item)
}

private val getResult =
    registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            (binding.recyclerView.adapter)?.
            notifyItemRangeChanged(0,app.comicbooks.findAll().size)
        }
    }

    override fun onComicbookClick(comicbook: ComicbookModel) {
        val launcherIntent = Intent(this, ComicbookActivity::class.java)
        launcherIntent.putExtra("Comicbook_edit", comicbook)
        getClickResult.launch(launcherIntent)
    }
    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.comicbooks.findAll().size)
            }
        }
}
