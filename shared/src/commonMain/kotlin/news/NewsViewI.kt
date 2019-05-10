package ch.makeitappen.common.news

import ch.makeitappen.bran.base.ViewI

interface NewsViewI : ViewI {
    fun show(newsList: List<News>)

    fun showDetail(news:News)
}