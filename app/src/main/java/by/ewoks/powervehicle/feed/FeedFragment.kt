package by.ewoks.powervehicle.feed

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.entities.Event
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment(R.layout.fragment_feed) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
        }
        val e1:Event= Event(null, System.currentTimeMillis()-5000, 0, "Event My 1", 100)
        val e2:Event= Event(null, System.currentTimeMillis()-5000, 0, "Event My 2", 200)
        val e3:Event= Event(null, System.currentTimeMillis()-5000, 0, "Event My 3", 300)
        val listIn:List<Event> = listOf(e1,e2,e3)
        val adapter = FeedAdapter(context,listIn ) { position, resource ->
            showDetailsFragment(position)
        }
        val list = feed_recycler
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = llm
        list.adapter = adapter


    }

    private fun showDetailsFragment( position: Int) {
        System.out.println("!!! showDetailsFragment " + position);
        //TODO Show Detail Info here
    }
}