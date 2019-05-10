package ch.makeitappen.common.article

import ch.makeitappen.bran.base.Presenter

class ArticlePresenter(private val articleRepository: ArticleRepository) : Presenter<ArticleViewI>() {

    override fun onViewAttached() {
        super.onViewAttached()
        loadNews()
    }

    private fun loadNews() {
        view?.show(articleRepository.news)
    }

}