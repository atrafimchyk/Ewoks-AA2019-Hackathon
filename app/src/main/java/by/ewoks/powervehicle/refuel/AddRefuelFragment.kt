package by.ewoks.powervehicle.refuel

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import kotlinx.android.synthetic.main.fragment_add_refuel.*
import java.text.SimpleDateFormat
import java.util.*

class AddRefuelFragment : Fragment(R.layout.fragment_add_refuel) {

    @SuppressLint("SimpleDateFormat")
    val stf = SimpleDateFormat("dd/mm/yyyy")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        etTextDate.setText(stf.format(Date()))

        val volume = etVolumeFuel.text.toString().toInt()
        val priceFuel = etPriceFuel.text.toString().toInt()

        saveFuelButton.setOnClickListener {
            if (etMileage.length() != 0
                    && etPriceFuel.length() != 0
                    && etVolumeFuel.length() != 0)
                activity?.onBackPressed()
            else {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_LONG).show()
            }
        }

        //добавление слушателей к полям

        etPriceFuel.addTextChangedListener {
            object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!p0.toString().equals("")) {
                        etTotalCost.setText(priceFuel * volume).toString()
                    }
                }
            }
        }
        etVolumeFuel.addTextChangedListener {
            object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!p0.toString().equals("")) {
                        etTotalCost.setText(priceFuel * volume).toString()
                    }
                }
            }
        }
    }
}