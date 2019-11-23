package by.ewoks.powervehicle.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.feed.FeedItem
import by.ewoks.powervehicle.common.feed.HintItem
import by.ewoks.powervehicle.common.feed.ServiceItem

class FeedAdapter(context: Context?, listIn:List<FeedItem>,
                  private val clickListener: (resource:FeedItem) -> Unit)  : RecyclerView.Adapter<FeedViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listIn:List<FeedItem> = listIn

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FeedViewHolder {
        System.out.println("!!! onCreateViewHolder ")

        var itemView = inflater.inflate(R.layout.feed_item, p0, false)
        if(p1 == 4){ //ServiceItem
            itemView = inflater.inflate(R.layout.feed_item_service, p0, false)
            return FeedViewHolderService(itemView)
        }
        if(p1 == 2){ ////HintItem
            itemView = inflater.inflate(R.layout.feed_item_hint, p0, false)
            return FeedViewHolderHint(itemView)
        }
        if(p1 == 1){ //StatRefuelItem
            itemView = inflater.inflate(R.layout.feed_item_stat, p0, false)
            return FeedViewHolderStat(itemView)
        }
        //TODO handle others
        return FeedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        System.out.println("!!! onBindViewHolder " + position)
        holder.bind(listIn.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return listIn.size
    }

    override fun getItemViewType(position: Int): Int {
        System.out.println("!!! listIn.get(position).toString()" + listIn.get(position).toString());
        var result=1 //StatRefuelItem
        if(listIn.get(position) is HintItem){
            result=2 //HintItem
        }
        if(listIn.get(position) is ServiceItem){
            result=4 //ServiceItem
        }
        return result
        //return super.getItemViewType(position)
    }
}