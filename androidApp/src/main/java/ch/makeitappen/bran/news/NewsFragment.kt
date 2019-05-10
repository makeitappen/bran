package ch.makeitappen.bran.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.makeitappen.bran.R
import ch.makeitappen.bran.article.ArticleFragment
import ch.makeitappen.bran.base.PresenterFragment
import ch.makeitappen.common.news.News
import ch.makeitappen.common.news.NewsPresenter
import ch.makeitappen.common.news.NewsRepository
import ch.makeitappen.common.news.NewsViewI

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NewsFragment.OnListFragmentInteractionListener] interface.
 */
class NewsFragment : PresenterFragment(), NewsViewI, OnNewsItemClickListener {

    private var columnCount = 1

    private var presenter = NewsPresenter(NewsRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        set(presenter)
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    // OnNewsItemClickListener
    override fun onNewsItemClick(news: News?) {
        news?.let { presenter.onNewsSelected(it) }
    }

    // NewsViewI
    override fun show(newsList: List<News>) {
        (view as? RecyclerView)?.adapter = NewsRecyclerViewAdapter(newsList, this)
    }

    // NewsViewI
    override fun showDetail(news: News) {
        val articleFragment = ArticleFragment(news)
        activity?.let {
            it.supportFragmentManager.beginTransaction()?.replace(R.id.frameLayout, articleFragment, "ArticleFragment")
                .addToBackStack(null).commit()
        }
    }

}
