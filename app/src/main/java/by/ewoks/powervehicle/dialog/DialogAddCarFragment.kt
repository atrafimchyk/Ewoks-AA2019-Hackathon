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
        val rootView = inflater.inflate(R.layout.add_car_fragment_layout, container)


        this.dialog!!.setTitle("AddCar")


        return rootView
    }
}