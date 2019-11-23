package by.ewoks.powervehicle.refuel

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import by.ewoks.powervehicle.Fragment
import by.ewoks.powervehicle.R
import kotlinx.android.synthetic.main.fragment_add_refuel.*
import java.text.SimpleDateFormat
import java.util.*


class AddRefuelFragment : Fragment(by.ewoks.powervehicle.R.layout.fragment_add_refuel) {

    @SuppressLint("SimpleDateFormat")
    val stf = SimpleDateFormat("mm/dd/yyyy")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Текущее время
        val currentDate = Date()
        // Форматирование времени как "день.месяц.год"
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val dateText = dateFormat.format(currentDate)
        etTextDate.setText(dateText)

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
        etPriceFuel.doOnTextChanged { text, start, count, after ->
            if (!text.toString().equals("")) {
                etTotalCost.setText((getPriceFul() * getVolume()).toString())
            }
        }

        etVolumeFuel.doOnTextChanged { text, start, count, after ->
                    if (!text.toString().equals("")) {
                        etTotalCost.setText((getPriceFul() * getVolume()).toString())

                    }
                }

    }

    private fun getPriceFul(): Int {
        val priceFuel = etPriceFuel.text.toString().toInt()
        return priceFuel
    }

    private fun getVolume(): Int {
        val volume = etVolumeFuel.text.toString().toInt()
        return volume
    }
}