package by.ewoks.powervehicle.feed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        feed_recycler.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }


        //val listIn: List<FeedItem> = GetDataForItemHelper.getFeedItemList().value ?: emptyList()
        GetDataForItemHelper.getFeedItemList().observe(viewLifecycleOwner, Observer { items ->
            val adapter = FeedAdapter(context, items) { resource ->
                showDetailsFragment(resource)
            }
            feed_recycler.adapter = adapter
        })
    }

    private fun showDetailsFragment(resource: FeedItem) {
        if (resource is HintItem) {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(resource.hint.hintUrl)
            }
            startActivity(intent)
        }
    }
}