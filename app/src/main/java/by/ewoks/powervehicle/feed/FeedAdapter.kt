package by.ewoks.powervehicle.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.entities.Event

class FeedAdapter(context: Context?, listIn:List<Event>,
                  private val clickListener: (position: Int, resource:Int) -> Unit)  : RecyclerView.Adapter<FeedViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listIn:List<Event> = listIn

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FeedViewHolder {
        System.out.println("!!! onCreateViewHolder ")

        return FeedViewHolder(inflater.inflate(R.layout.feed_item, p0, false), clickListener)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        System.out.println("!!! onBindViewHolder " + position)
        holder.bind(listIn.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return listIn.size
    }



}