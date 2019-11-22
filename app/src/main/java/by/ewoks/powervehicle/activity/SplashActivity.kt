package by.ewoks.powervehicle.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.ewoks.powervehicle.MainActivity
import by.ewoks.powervehicle.R
import by.ewoks.powervehicle.dialog.DialogAddCarFragment

/*
    * First Activity in the app. Splash in feature. Now used only to choose either start main activity or frow car choosing fragment
     */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onResume() {
        super.onResume()
        chooseWhereToGo()
    }

    // show fragment to add new car if nothing exists or show Main activity with data
    private fun chooseWhereToGo (){
        if(!doesCarExists()) {
            val fm = supportFragmentManager
            val addCarFragment = DialogAddCarFragment()
            addCarFragment.show(fm, "PioneersFragment_tag")
        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    /*
    * true if any car already exists and data could be shown
     */
    private fun doesCarExists(): Boolean {

        return false;
    }
}