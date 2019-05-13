package ch.makeitappen.common.article

import ch.makeitappen.bran.base.Presenter

class ArticlePresenter(private val articleRepository: ArticleRepository) : Presenter<ArticleViewI>() {

    override fun onViewAttached() {
        super.onViewAttached()
        loadNews()
    }

    override fun onViewDetached() {
        super.onViewDetached()
        stopLoadingNews()
    }

    private fun loadNews() {
        view?.show(articleRepository.news)
    }

    private fun stopLoadingNews() {
        view?.stopLoading(articleRepository.news)
    }


}