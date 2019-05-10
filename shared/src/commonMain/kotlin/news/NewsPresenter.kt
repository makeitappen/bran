package ch.makeitappen.common.news

import ch.makeitappen.bran.base.Presenter

class NewsPresenter(private val repository: NewsRepository) :
    Presenter<NewsViewI>() {

    fun onNewsSelected(news: News) {
        view?.showDetail(news)
    }

    private fun loadNewsList() {
        view?.show(repository.newsList())

    }

    override fun onViewAttached() {
        super.onViewAttached()
        loadNewsList()
    }
}