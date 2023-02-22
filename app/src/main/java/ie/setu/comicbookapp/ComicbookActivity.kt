package ie.setu.comicbookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import timber.log.Timber.i

class ComicbookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comicbook)

        Timber.plant(Timber.DebugTree())

        i(" Comic Book has been started..")
    }
}