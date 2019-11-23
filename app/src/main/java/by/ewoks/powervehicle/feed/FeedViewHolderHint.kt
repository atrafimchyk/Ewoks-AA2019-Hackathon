package by.ewoks.powervehicle.feed

import android.view.View
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderHint(
        itemView: View
) : FeedViewHolder(itemView) {

    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {

        (feedItem as? HintItem)?.let { hintItem ->
            feed_event_title_text.text = hintItem.hint.headerText
            feed_mileage_title_text.text = hintItem.hint.bodyText
            feed_mileage_text.text = hintItem.hint.conditionMileage.toString()
            feed_event_text.text = ""
            setOnClickListener { clickListener(hintItem) }
        }

        Unit
    }
}