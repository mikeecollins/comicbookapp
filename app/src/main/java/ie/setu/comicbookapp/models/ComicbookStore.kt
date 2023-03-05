package ie.setu.comicbookapp.models

interface ComicbookStore {
    fun findAll(): List<ComicbookModel>
    fun create(comicbook: ComicbookModel)
    fun update(comicbook: ComicbookModel)
}