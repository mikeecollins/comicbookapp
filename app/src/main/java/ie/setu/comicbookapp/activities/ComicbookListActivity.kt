package ie.setu.comicbookapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.setu.comicbookapp.R
import ie.setu.comicbookapp.main.MainApp

class ComicbookListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comicbook_list)
        app = application as MainApp
    }
}