package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.feed_item.view.*

open class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {
        feed_event_text.text = "demo1"
        feed_mileage_text.text = "demo2"
        setOnClickListener { clickListener(feedItem) }
    }
}