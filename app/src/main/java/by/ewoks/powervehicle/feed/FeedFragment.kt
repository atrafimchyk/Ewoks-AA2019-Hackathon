package by.ewoks.powervehicle.feed

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.helpers.GetDataForItemHelper
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment(R.layout.fragment_feed) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        val listIn: List<FeedItem> = GetDataForItemHelper.getFeedItemList(context)
        val adapter = FeedAdapter(context, listIn) { resource ->
            showDetailsFragment(resource)
        }
        val list = feed_recycler
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter


    }

    private fun showDetailsFragment(resource: FeedItem) {
        Toast.makeText(requireContext(), "click on ${resource::class.java.simpleName}", Toast.LENGTH_SHORT).show()
    }
}