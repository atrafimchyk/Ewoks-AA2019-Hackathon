package by.ewoks.powervehicle.helpers

import android.content.Context


class SharedPreferencesHelper {

    companion object {

       val PREFERENCE_NAME:String = "PREFERENCE_NAME"
        /*
        * SHARED_LAST_CAR_ID_KEY - this should save last (currently used) ID of the car
         */
        val SHARED_LAST_CAR_ID_KEY:String = "SHARED_LAST_CAR_ID_KEY"

        fun addLastID(context: Context?, id: Long) {
            val sharedPreference =  context!!.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.putLong(SHARED_LAST_CAR_ID_KEY,id)
            editor.commit()
        }

        @JvmStatic
        fun getLastID(context: Context?) :Long {
            val sharedPreference =  context!!.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sharedPreference.getLong(SHARED_LAST_CAR_ID_KEY,-1)
        }
    }
}
