package ie.setu.comicbookapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.wear.tiles.material.Button
import com.google.android.material.snackbar.Snackbar
import ie.setu.comicbookapp.R
import ie.setu.comicbookapp.databinding.ActivityComicbookBinding
import ie.setu.comicbookapp.main.MainApp
import ie.setu.comicbookapp.models.ComicbookModel

import timber.log.Timber.i

class ComicbookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicbookBinding
    var comicbook = ComicbookModel()
    val comicbooks = ArrayList<ComicbookModel>()
    lateinit var app: MainApp

    var edit = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp

        //val deleteButton = findViewById<ComicbookModel>(R.id.deleteButton)
        //deleteButton.setOnClickListener {
        // My delete function

        if (intent.hasExtra("Comicbook update")) {
            edit = true
            comicbook = intent.extras?.getParcelable("placemark_edit")!!
            binding.comicbookTitle.setText(comicbook.title)
            binding.description.setText(comicbook.description)
            binding.btnAdd.setText(R.string.save_comicbook)
        }
        if (intent.hasExtra("comicbook_edit")) {
            comicbook = intent.extras?.getParcelable("comicbook_edit")!!
            binding.comicbookTitle.setText(comicbook.title)
            binding.description.setText(comicbook.description)
        }
        i("Comicbook Activity started...")

        binding.btnAdd.setOnClickListener() {
            comicbook.title = binding.comicbookTitle.text.toString()
            comicbook.description = binding.description.text.toString()
            if (comicbook.title.isNotEmpty()) {
                Snackbar.make(it, R.string.enter_comicbook_title, Snackbar.LENGTH_LONG)
                    .show()
            } else {
                if (edit) {
                    app.comicbooks.update(comicbook.copy())
                } else {
                    app.comicbooks.create(comicbook.copy())
                }
            }
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_comicbook, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }



}