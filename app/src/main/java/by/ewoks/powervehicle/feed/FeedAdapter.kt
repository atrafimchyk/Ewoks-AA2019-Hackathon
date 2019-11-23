package by.ewoks.powervehicle.feed

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import by.ewoks.powervehicle.BR
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.binding
import by.ewoks.powervehicle.common.entities.Refuel

class FeedAdapter(private val list: List<Refuel>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = binding(parent, R.layout.feed_item)
        return FeedViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class FeedViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Refuel) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}