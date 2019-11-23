package by.ewoks.powervehicle

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import by.ewoks.powervehicle.common.AppDbManager
import by.ewoks.powervehicle.common.koin.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PowerVehicleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDbManager.initDb(this)
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@PowerVehicleApp)
            modules(module)
        }
    }
}

fun binding(parent: ViewGroup, layout: Int): ViewDataBinding {
    val inflater = LayoutInflater.from(parent.context)
    return DataBindingUtil.inflate<ViewDataBinding>(
            inflater, layout, parent, false
    )
}