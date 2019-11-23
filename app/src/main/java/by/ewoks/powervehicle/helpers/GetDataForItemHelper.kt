package by.ewoks.powervehicle.helpers

import android.content.Context
import by.ewoks.powervehicle.calculator.model.StatRefuel
import by.ewoks.powervehicle.common.entities.*


class GetDataForItemHelper {

    companion object {

        fun getFeedItemList(context: Context?): List<FeedItem> {
            val hint: HintItem = HintItem(Hint(null, 1, "Header", "Body", "Url" , 200))
            val serv: ServiceItem = ServiceItem(Service(null, 1, 1, 100000090,100022090,23452, "Name", "Desc" , 200.0))
            val stat: StatRefuelItem = StatRefuelItem(StatRefuel(Refuel(null, 123123123,1,12.4, 123123, 300.0, false), 999, 100.0 , 200.0))

            val e1: FeedItem = hint
            val e2: FeedItem = serv
            val e3: FeedItem = stat
            val listIn:List<FeedItem> = listOf(e1,e2,e3)
            return listIn
        }
    }
}
