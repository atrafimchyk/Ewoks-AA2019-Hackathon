package by.ewoks.powervehicle.datasource

import by.ewoks.powervehicle.common.entities.ServiceType

object ServiceTypesDataSource {

    val TYPES: List<ServiceType> = listOf(
            ServiceType(1, "Замена моторного масла с фильтром"),
            ServiceType(2, "Замена топливного фильтра"),
            ServiceType(3, "Замена воздушного фильтра"),
            ServiceType(4, "Замена салонного фильтра"),
            ServiceType(5, "Замена тормозной жидкости"),
            ServiceType(6, "Замена антифриза"),
            ServiceType(7, "Замена свечей зажигания"),
            ServiceType(8, "Замена ремня ГРМ"),
            ServiceType(9, "Регулировка клапанов"),
            ServiceType(10, "Балансировка колес"),
            ServiceType(11, "Мойка"),
            ServiceType(12, "Страховка"),
            ServiceType(13, "Техосмотр")
    )

}