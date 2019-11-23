package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.entities.FeedItem
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(feedItem: FeedItem, clickListener: (position: Int, resource: Int) -> Unit) = with(itemView) {
        feed_event_text.text = "1"//feedItem.toString()
        feed_mileage_text.text = "2"//feedItem.toString()
        setOnClickListener { clickListener }
    }


}
