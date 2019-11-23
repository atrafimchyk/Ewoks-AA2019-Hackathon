package by.ewoks.powervehicle.common

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import by.ewoks.powervehicle.datasource.ServiceTypesDataSource
import by.ewoks.powervehicle.runOnIoThread

object AppDbManager {

    private lateinit var appDb: AppDb

    private val DB_INIT_CALLBACK = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            runOnIoThread {
                getDb().serviceTypeDao()
                        .insertAllServiceTypes(ServiceTypesDataSource.TYPES)
            }
        }
    }

    fun initDb(appContext: Context) {
        appDb = Room
                .databaseBuilder(
                        appContext,
                        AppDb::class.java,
                        "PowerVehicleDb"
                )
                .allowMainThreadQueries()
                .addCallback(DB_INIT_CALLBACK)
                .allowMainThreadQueries()
                .build()
    }

    fun getDb() = appDb
}