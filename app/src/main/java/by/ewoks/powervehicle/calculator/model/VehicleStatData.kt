package by.ewoks.powervehicle.calculator.model

data class VehicleStatData(
        val totalMileage: Int,  //km
        val totalFuelExpense: Double,   //BYN
        val totalServiceExpense: Double,    //BYN
        val totalFuelBurnt: Double, // L
        val averageFuelConsumption: Double, // L/100km
        val averageMileageOnOneRefuel: Double,  //km
        val drivingCostFuelOnly: Double,    // BYN/100km
        val drivingCostServiceAndFuel: Double   // BYN/100km
)