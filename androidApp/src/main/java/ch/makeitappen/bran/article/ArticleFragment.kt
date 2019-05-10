package ch.makeitappen.bran.article


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import ch.makeitappen.bran.R
import ch.makeitappen.bran.base.PresenterFragment
import ch.makeitappen.bran.utliities.ProgressBarWebClient
import ch.makeitappen.common.article.ArticlePresenter
import ch.makeitappen.common.article.ArticleRepository
import ch.makeitappen.common.article.ArticleViewI
import ch.makeitappen.common.news.News
import kotlinx.android.synthetic.main.fragment_article.*


/**
 * A simple [Fragment] subclass.
 *
 */
class ArticleFragment(private val news: News) : PresenterFragment(), ArticleViewI {

    private var presenter = ArticlePresenter(ArticleRepository(news))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        val webView: WebView = view.findViewById(R.id.webView)
        val progressBar: ProgressBar = view.findViewById(R.id.progress_circular)
        webView.webViewClient = ProgressBarWebClient(progressBar)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        set(presenter)
    }

    // ArticleViewI
    override fun show(news: News) {

        webView.loadUrl(news.link)
    }

}