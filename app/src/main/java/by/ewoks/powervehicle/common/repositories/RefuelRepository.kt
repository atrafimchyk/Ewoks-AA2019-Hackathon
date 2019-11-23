package by.ewoks.powervehicle.common.repositories

import androidx.lifecycle.LiveData
import by.ewoks.powervehicle.common.dao.RefuelDao
import by.ewoks.powervehicle.common.entities.Refuel

class RefuelRepository(private val refuelDao: RefuelDao) {

    val feed: LiveData<List<Refuel>>
        get() = refuelDao.getAllRefuels()

    suspend fun insertRefuel(refuel: Refuel) {
        refuelDao.insertRefuel(refuel)
    }
}