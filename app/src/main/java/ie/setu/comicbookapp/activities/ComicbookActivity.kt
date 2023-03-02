package ie.setu.comicbookapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.comicbookapp.databinding.ActivityComicbookBinding
import ie.setu.comicbookapp.models.ComicbookModel
import timber.log.Timber
import timber.log.Timber.i

class ComicbookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicbookBinding
    var comicbook = ComicbookModel()
    val comicbooks = ArrayList<ComicbookModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicbookBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Timber.plant(Timber.DebugTree())

        i(" Comic Book has been started..")

        binding.btnAdd.setOnClickListener() {
            comicbook.title = binding.comicbookTitle.text.toString()
            comicbook.description = binding.description.text.toString()
            if (comicbook.title.isNotEmpty()) {
                comicbooks.add(comicbook)

                comicbooks.add(comicbook.copy())

                i("add Button Pressed: ${comicbook}")
                for (i in comicbooks.indices) {
                    i("Comicbook[$i]:${this.comicbooks[i]}")
                }
            } else {
                Snackbar.make(it, "Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}

