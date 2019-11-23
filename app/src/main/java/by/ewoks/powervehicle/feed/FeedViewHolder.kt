package by.ewoks.powervehicle.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.common.entities.Event
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedViewHolder(
        itemView: View,
        clickListener: (position: Int, resource: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bind(event: Event, clickListener: (position: Int, resource: Int) -> Unit) = with(itemView) {
        feed_event_text.text = event.event
        feed_mileage_text.text = event.mileage.toString()
        setOnClickListener { clickListener }
    }


}
