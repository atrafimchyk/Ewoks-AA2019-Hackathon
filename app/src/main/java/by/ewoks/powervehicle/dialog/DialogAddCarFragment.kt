package by.ewoks.powervehicle.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import by.ewoks.powervehicle.R

/*
* dialog to enter new car with its data
 */
class DialogAddCarFragment  : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fraglayout, container)
        var pioneers = arrayOf("Dennis Ritchie", "Rodney Brooks", "Sergey Brin", "Larry Page", "Cynthia Breazeal", "Jeffrey Bezos", "Berners-Lee Tim", "Centaurus A", "Virgo Stellar Stream")

        val myListView = rootView.findViewById(R.id.myListView) as ListView
        //with arrayadapter you have to pass a textview as a resource, and that is simple_list_item_1
        myListView!!.adapter = ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, pioneers)

        this.dialog.setTitle("Tech Pioneers")

        myListView.setOnItemClickListener {
            adapterView,
            view,
            position,
            l
            -> Toast.makeText(activity, pioneers[position], Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}