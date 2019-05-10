package ch.makeitappen.common.article

import ch.makeitappen.bran.base.ViewI
import ch.makeitappen.common.news.News

interface ArticleViewI : ViewI {
    fun show(news: News)
}