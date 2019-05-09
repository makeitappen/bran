package ch.makeitappen.common.news

import ch.makeitappen.bran.base.Presenter

class NewsPresenter : Presenter<NewsViewI>() {

    private val repository = NewsRepository()

    fun loadNews() {
        view?.show(repository.news())
    }
}