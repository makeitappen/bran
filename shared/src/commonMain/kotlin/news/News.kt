package ch.makeitappen.common.news

import io.ktor.http.Url

data class News(val title: String, val detail: String, val link: Url, val imageUrl: Url? = null)