package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.feed.FeedItem
import by.ewoks.powervehicle.common.feed.HintItem
import by.ewoks.powervehicle.common.feed.ServiceItem
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderHint(
        itemView: View
) : FeedViewHolder(itemView) {
    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {
        feed_event_title_text.text = (feedItem as HintItem).hint.headerText
        feed_mileage_title_text.text = (feedItem as HintItem).hint.bodyText
        feed_mileage_text.text = (feedItem as HintItem).hint.conditionMileage.toString()
        feed_event_text.text = ""
        setOnClickListener { clickListener(feedItem) }
    }


}