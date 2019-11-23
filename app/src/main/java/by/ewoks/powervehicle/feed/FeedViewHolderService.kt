package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.feed.FeedItem
import by.ewoks.powervehicle.common.feed.HintItem
import by.ewoks.powervehicle.common.feed.ServiceItem
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderService(
        itemView: View
) : FeedViewHolder(itemView) {
    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {
        feed_event_text.text = (feedItem as ServiceItem).service.name
        feed_mileage_text.text = (feedItem as ServiceItem).service.mileage.toString()
        setOnClickListener { clickListener(feedItem) }
    }


}