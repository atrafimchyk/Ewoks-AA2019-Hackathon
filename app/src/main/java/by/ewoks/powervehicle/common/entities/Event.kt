package by.ewoks.powervehicle.common.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
        @PrimaryKey(autoGenerate = true) val id: Long?,
        val date: Long,
        @ColumnInfo(name = "vehicle_id") val vehicleId: Long?,
        @ColumnInfo(name = "event") val event: String,
        @ColumnInfo(name = "mileage") val mileage: Int

)