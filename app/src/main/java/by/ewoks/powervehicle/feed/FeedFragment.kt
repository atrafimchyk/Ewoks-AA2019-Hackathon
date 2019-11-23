package by.ewoks.powervehicle.feed

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.entities.*
import by.ewoks.powervehicle.common.feed.FeedItem
import by.ewoks.powervehicle.helpers.GetDataForItemHelper
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment(R.layout.fragment_feed) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        val listIn:List<FeedItem> = GetDataForItemHelper.getFeedItemList(context)
        val adapter = FeedAdapter(context,listIn ) { resource ->
            showDetailsFragment(resource)
        }
        val list = feed_recycler
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter


    }



    private fun showDetailsFragment( resource: FeedItem) {
        System.out.println("!!! showDetailsFragment " + resource.toString());
        //TODO Show Detail Info here
    }


}