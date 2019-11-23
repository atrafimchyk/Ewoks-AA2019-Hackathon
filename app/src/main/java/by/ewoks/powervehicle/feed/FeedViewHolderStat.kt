package by.ewoks.powervehicle.feed

import adapter.StatRefuel
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.feed.FeedItem
import by.ewoks.powervehicle.common.feed.StatRefuelItem
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolderStat(
        itemView: View
) : FeedViewHolder(itemView) {
    override fun bind(feedItem: FeedItem, clickListener: (resource: FeedItem) -> Unit) = with(itemView) {

        feed_event_title_text.text ="Заправка:"
        feed_event_text.text = "BYN "+(feedItem as StatRefuelItem).stat.incrementMoney.toString()
        feed_mileage_text.text = (feedItem as StatRefuelItem).stat.refuel.mileage.toString()

        setOnClickListener { clickListener(feedItem) }
    }


}