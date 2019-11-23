package by.ewoks.powervehicle.helpers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import by.ewoks.powervehicle.calculator.Calculator
import by.ewoks.powervehicle.common.AppDbManager
import by.ewoks.powervehicle.feed.FeedItem
import by.ewoks.powervehicle.feed.HintItem
import by.ewoks.powervehicle.feed.ServiceItem
import by.ewoks.powervehicle.feed.StatRefuelItem

class GetDataForItemHelper {

    companion object {

        fun getFeedItemList(): LiveData<List<FeedItem>> {

            val result = MediatorLiveData<List<FeedItem>>()

            val db = AppDbManager.getDb()
            val refuels = db.refuelDao().getAllRefuels()
            val services = db.serviceDao().getAllServices()
            val hints = db.hintDao().getAllHints()

            result.addSource(refuels) { refuelList ->
                result.value = Calculator.makeStatRefuelList(refuelList)?.map { statRefuel ->
                    StatRefuelItem(statRefuel)
                } ?: emptyList<StatRefuelItem>()
            }


            result.addSource(services) { serviceList ->
                result.value = services.value?.map { service ->
                    ServiceItem(service)
                } ?: emptyList<ServiceItem>()
            }


            result.addSource(hints) {hintList ->
                result.value = hints.value?.map { hint ->
                    HintItem(hint)
                } ?: emptyList<HintItem>()
            }

            return result
        }
    }
}
