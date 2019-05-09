package ch.makeitappen.bran.news


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.makeitappen.bran.R
import ch.makeitappen.common.news.News
import kotlinx.android.synthetic.main.fragment_news.view.*

interface OnNewsItemClickListener {
    // TODO: Update argument type and name
    fun onNewsItemClick(news: News?)
}


class NewsRecyclerViewAdapter(
    private val mValues: List<News>,
    private val mListener: OnNewsItemClickListener?
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val news = v.tag as News
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onNewsItemClick(news)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.title
        holder.mContentView.text = item.detail

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
