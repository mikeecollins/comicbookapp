package ie.setu.comicbookapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.comicbookapp.databinding.ActivityComicbookBinding
import timber.log.Timber
import timber.log.Timber.i

class ComicbookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicbookBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Timber.plant(Timber.DebugTree())

        i(" Comic Book has been started..")

        binding.btnAdd.setOnClickListener() {
            val comicbookTitle = binding.comicbookTitle.text.toString()
            if (comicbookTitle.isNotEmpty()) {
                i("add Button Pressed: $comicbookTitle")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}