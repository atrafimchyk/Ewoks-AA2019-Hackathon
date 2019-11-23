package by.ewoks.powervehicle.feed

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.entities.Refuel
import by.ewoks.powervehicle.common.repositories.RefuelRepository
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.android.ext.android.inject

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private val refuelRepository: RefuelRepository by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }

        refuelRepository.feed.observe(viewLifecycleOwner, Observer { feed ->
            if (feed.isNotEmpty()) {
//                setupRecycler(feed)
            }
        })
    }

//    private fun setupRecycler(feed: List<Refuel>) {
//        with(feed_recycler) {
//            adapter = FeedAdapter(feed)
//            layoutManager = LinearLayoutManager(context)
//        }
//    }
}
