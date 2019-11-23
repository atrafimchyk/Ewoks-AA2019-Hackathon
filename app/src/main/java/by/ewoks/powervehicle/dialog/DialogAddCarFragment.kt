package by.ewoks.powervehicle.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.common.AppDbManager
import by.ewoks.powervehicle.common.entities.Refuel
import by.ewoks.powervehicle.common.entities.Vehicle
import by.ewoks.powervehicle.helpers.MyDialogCallback
import by.ewoks.powervehicle.helpers.SharedPreferencesHelper
import kotlinx.android.synthetic.main.add_car_fragment_layout.*


/*
* dialog to enter new car with its data
 */
class DialogAddCarFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.add_car_fragment_layout, container)
        this.dialog!!.setTitle("AddCar")
        return rootView
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        // handle "Add new car" button click
        btn_add.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                saveNewCar()
                (activity as MyDialogCallback).finishCallback()
                dismiss()
            }
        })
    }

    private fun saveNewCar() {
        // Get data to save from EditTexts
        val name: String = (edit_name as EditText).text.toString()
        val vin: String = (edit_vin as EditText).text.toString()
        val km: Int = (edit_km as EditText).text.toString().toInt()
        val air: Int = (edit_air as EditText).text.toString().toInt()
        val fuel: Int = (edit_fuel as EditText).text.toString().toInt()
        val belt: Int = (edit_belt as EditText).text.toString().toInt()
        val brake: Int = (edit_brake as EditText).text.toString().toInt()
        val antifreeze: Int = (edit_antifreeze as EditText).text.toString().toInt()
        val oil: Int = (edit_oil as EditText).text.toString().toInt()
        val salon: Int = (edit_salon as EditText).text.toString().toInt()
        val spark: Int = (edit_spark as EditText).text.toString().toInt()
        val strokes: Int = (edit_strokes as EditText).text.toString().toInt()
        val wheel: Int = (edit_wheel as EditText).text.toString().toInt()
        val vehicle: Vehicle = Vehicle(null, name, vin, oil, brake, fuel, air, salon, spark, belt, strokes, wheel, antifreeze)

        // Save new car to DB
        val result: Long = AppDbManager.getDb().vehicleDao().insertVehicle(vehicle)
        if (result > -1) {
            // Save Actual car ID to SharedPreferences
            SharedPreferencesHelper.addLastID(context, result)
            // Save fake Refuel - just for adding "km" parameter
            val refuel: Refuel = Refuel(null, System.currentTimeMillis(), result, 0.0, km, 0.0, false)
            AppDbManager.getDb().refuelDao().insertRefuel(refuel)
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }
}