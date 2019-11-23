package by.ewoks.powervehicle.common.koin

import androidx.room.Room
import by.ewoks.powervehicle.common.AppDb
import by.ewoks.powervehicle.common.repositories.RefuelRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val module = module {
    single {
        return@single Room.databaseBuilder(
                androidContext(), AppDb::class.java, "finance_database"
        ).build()
    }

    single {
        val db = get() as AppDb
        return@single db.refuelDao()
    }

    single { RefuelRepository(get()) }
}
