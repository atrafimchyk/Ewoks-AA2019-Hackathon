package by.ewoks.powervehicle.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.R

class FeedAdapter(
        context: Context?,
        listIn: List<FeedItem>,
        private val clickListener: (resource: FeedItem) -> Unit
) : RecyclerView.Adapter<FeedViewHolder>() {

    companion object {

        private const val ITEM_REFUEL = 1
        private const val ITEM_HINT = 2
        private const val ITEM_SERVICE = 4
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listIn: List<FeedItem> = listIn

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        var itemView = inflater.inflate(R.layout.feed_item, parent, false)

        if (viewType == ITEM_SERVICE) { //ServiceItem
            itemView = inflater.inflate(R.layout.feed_item_service, parent, false)
            return FeedViewHolderService(itemView)
        }
        if (viewType == ITEM_HINT) { ////HintItem
            itemView = inflater.inflate(R.layout.feed_item_hint, parent, false)
            return FeedViewHolderHint(itemView)
        }
        if (viewType == ITEM_REFUEL) { //StatRefuelItem
            itemView = inflater.inflate(R.layout.feed_item_stat, parent, false)
            return FeedViewHolderStat(itemView)
        }
        // default
        return FeedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        when (getItemViewType(position)) {
            ITEM_REFUEL -> (holder as FeedViewHolderStat).bind(listIn[position], clickListener)
            ITEM_HINT -> (holder as FeedViewHolderHint).bind(listIn[position], clickListener)
            ITEM_SERVICE -> (holder as FeedViewHolderService).bind(listIn[position], clickListener)
            else -> holder.bind(listIn[position], clickListener)
        }
    }

    override fun getItemCount(): Int {
        return listIn.size
    }

    override fun getItemViewType(position: Int): Int {
        var result = ITEM_REFUEL
        if (listIn[position] is HintItem) {
            result = ITEM_HINT
        }
        if (listIn[position] is ServiceItem) {
            result = ITEM_SERVICE
        }
        return result
    }
}