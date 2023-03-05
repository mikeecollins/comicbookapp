package ie.setu.comicbookapp.main


import android.app.Application
import ie.setu.comicbookapp.models.ComicbookModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {
    val comicbooks = ArrayList<ComicbookModel>()
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Placemark started")
        comicbooks.add(ComicbookModel("One", "About one..."))
        comicbooks.add(ComicbookModel("Two", "About two..."))
        comicbooks.add(ComicbookModel("Three", "About three..."))
    }

}