package by.ewoks.powervehicle.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.ewoks.powervehicle.MainActivity
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.dialog.DialogAddCarFragment
import by.ewoks.powervehicle.helpers.MyDialogCallback
import by.ewoks.powervehicle.helpers.SharedPreferencesHelper

/*
    * First Activity in the app. Splash in feature. Now used only to choose either start main activity or frow car choosing fragment
     */
class SplashActivity : AppCompatActivity(), MyDialogCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onResume() {
        super.onResume()
        chooseWhereToGo()
    }

    override fun finishCallback() {
        chooseWhereToGo()
    }

    // show fragment to add new car if nothing exists or show Main activity with data
    private fun chooseWhereToGo() = if (!doesCarExists()) {
        // Show dialog to add new car:
        val fm = supportFragmentManager

        val addCarFragment = DialogAddCarFragment()
        addCarFragment.isCancelable = false
        addCarFragment.show(fm, "AddCarFragment_tag")
    } else {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    /*
    * true if any car already exists and data could be shown
     */
    private fun doesCarExists(): Boolean {
        // if LastAddedCar Id exists, car should exist too
        return SharedPreferencesHelper.getLastID(this) > -1
    }


}