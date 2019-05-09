package ch.makeitappen.common.news

import io.ktor.http.Url

class NewsRepository {
    fun news(): List<News> {
        return listOf(
            News(
                "North Korea fires two short-range missiles, South says",
                "Two short-range missiles are reportedly fired as a US envoy visits the region to revive nuclear talks.",
                Url("https://www.bbc.co.uk/news/world-asia-48212045")
            ),
            News(
                "Montenegro jails 'Russian coup plot' leaders",
                "A court jails two opposition leaders for five years and two Russians who are absent.",
                Url("https://www.bbc.co.uk/news/world-europe-48212435")
            )
        )
    }
}