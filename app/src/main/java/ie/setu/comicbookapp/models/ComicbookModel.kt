package ie.setu.comicbookapp.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class ComicbookModel(var title: String = "",
                          var description: String = "",
                          var id: Long = 0,
)  :Parcelable


