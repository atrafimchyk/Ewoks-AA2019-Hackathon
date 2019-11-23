package by.ewoks.powervehicle.services

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_service.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener

class AddServiceFragment : Fragment(R.layout.fragment_add_service), KeyboardVisibilityEventListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        service_types_spinner.create()

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        KeyboardVisibilityEvent.setEventListener(activity, this)
    }

    private fun Spinner.create() {
        val array = R.array.service_types

        val spinnerAdapter = ArrayAdapter.createFromResource(
                context,
                array,
                android.R.layout.simple_spinner_item
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        service_types_spinner.adapter = spinnerAdapter
    }

    override fun onVisibilityChanged(isOpen: Boolean) {
        if (isOpen) {
            activity?.bottom_navigation_view!!.visibility = View.GONE
            title_text.visibility = View.GONE
            service_types_spinner.visibility = View.GONE
            service_type_title_text.visibility = View.GONE
        } else {
            activity?.bottom_navigation_view!!.visibility = View.VISIBLE
            title_text.visibility = View.VISIBLE
            service_types_spinner.visibility = View.VISIBLE
            service_type_title_text.visibility = View.VISIBLE
        }
    }
}