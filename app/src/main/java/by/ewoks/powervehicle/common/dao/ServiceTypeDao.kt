package by.ewoks.powervehicle.common.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.ewoks.powervehicle.common.entities.ServiceType

@Dao
interface ServiceTypeDao {

    @Insert
    fun insertServiceType(serviceType: ServiceType)

    @Insert
    fun insertAllServiceTypes(serviceTypes: List<ServiceType>)

    @Query("SELECT * FROM ServiceType")
    fun getAllServiceTypes(): LiveData<List<ServiceType>>
}