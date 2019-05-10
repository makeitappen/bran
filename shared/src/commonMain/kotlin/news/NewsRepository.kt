package ch.makeitappen.common.news

open class NewsRepository(private val rssUrl: String) {

    fun newsList(): List<News> {

        // TODO: get RSS feed from network
        // Accept header needs to be set to 'applicaiton/xml'
        return listOf(
            News(
                "North Korea fires two short-range missiles, South says",
                "Two short-range missiles are reportedly fired as a US envoy visits the region to revive nuclear talks.",
                "https://www.bbc.co.uk/news/world-asia-48212045"
            ),
            News(
                "Montenegro jails 'Russian coup plot' leaders",
                "A court jails two opposition leaders for five years and two Russians who are absent.",
                "https://www.bbc.co.uk/news/world-europe-48212435"
            )
        )
    }
}