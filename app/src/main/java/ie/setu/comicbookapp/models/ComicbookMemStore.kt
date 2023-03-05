package ie.setu.comicbookapp.models

import timber.log.Timber.i


var lastId = 0L

internal fun getId(): Long {
    return lastId++
}
class ComicbookMemStore : ComicbookStore {

    val comicbooks = ArrayList<ComicbookModel>()

    override fun findAll(): List<ComicbookModel> {
        return comicbooks
    }

    override fun create(comicbook: ComicbookModel) {
        comicbooks.add(comicbook)
        comicbooks.add(comicbook)
        logAll()

    }

    override fun update(comicbook: ComicbookModel) {
        var foundComicbook: ComicbookModel? = comicbooks.find { p -> p.id == comicbook.id }
        if (foundComicbook != null) {
            foundComicbook.title = comicbook.title
            foundComicbook.description = comicbook.description
            logAll()
        }
    }
    fun logAll() {
        comicbooks.forEach{ i("${it}") }
    }


}