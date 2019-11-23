package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.feed.FeedItem
import kotlinx.android.synthetic.main.feed_item.view.*

open class FeedViewHolder(
        itemView: View
)  : RecyclerView.ViewHolder(itemView) {
    open fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {


        feed_event_text.text = "55521"//feedItem.toString()
        feed_mileage_text.text = "5"//feedItem.toString()
        setOnClickListener { clickListener(feedItem) }
    }
}