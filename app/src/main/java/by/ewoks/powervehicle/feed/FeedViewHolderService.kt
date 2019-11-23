package by.ewoks.powervehicle.feed

import android.view.View
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderService(
        itemView: View
) : FeedViewHolder(itemView) {

    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {

        (feedItem as? ServiceItem)?.let { serviceItem ->
            feed_event_text.text = serviceItem.service.name
            feed_mileage_text.text = serviceItem.service.mileage.toString()
            setOnClickListener { clickListener(serviceItem) }
        }

        Unit
    }
}