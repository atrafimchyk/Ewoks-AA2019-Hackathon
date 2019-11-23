package by.ewoks.powervehicle.services

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.AppDbManager
import kotlinx.android.synthetic.main.fragment_add_service.*

class AddServiceFragment : Fragment(R.layout.fragment_add_service) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val serviceTypeDao = AppDbManager.getDb().serviceTypeDao()
        serviceTypeDao.getAllServiceTypes().observe(viewLifecycleOwner, Observer { services ->
            val types = ArrayList<String>()
            services.forEach {
                types.add(it.name)
            }
            service_types_spinner.create(types)
        })
    }

    private fun Spinner.create(services: ArrayList<String>) {
        val spinnerAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, services)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        service_types_spinner.adapter = spinnerAdapter
    }
}