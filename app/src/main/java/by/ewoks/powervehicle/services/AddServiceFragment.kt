package by.ewoks.powervehicle.services

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.AppDbManager
import kotlinx.android.synthetic.main.fragment_add_service.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddServiceFragment : Fragment(R.layout.fragment_add_service) {

    private var serviceTypeId: Long = 0

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

        service_types_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                serviceTypeId = (position + 1).toLong()
            }
        }

        done_btn.setOnClickListener {

            // TODO adding service

            GlobalScope.launch {
                AppDbManager.getDb().serviceDao()
            }
        }
    }

    private fun Spinner.create(services: ArrayList<String>) {
        val spinnerAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, services)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        service_types_spinner.adapter = spinnerAdapter
    }
}