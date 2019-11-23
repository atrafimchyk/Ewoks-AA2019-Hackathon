package by.ewoks.powervehicle.feed

import android.view.View
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderStat(
        itemView: View
) : FeedViewHolder(itemView) {

    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {

        (feedItem as? StatRefuelItem)?.let { statItem ->
            feed_event_title_text.text = "Заправка:"
            feed_event_text.text = "BYN " + statItem.stat.incrementMoney.toString()
            feed_mileage_text.text = statItem.stat.refuel.mileage.toString()

            setOnClickListener { clickListener(statItem) }
        }

        Unit
    }
}