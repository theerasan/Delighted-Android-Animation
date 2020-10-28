package da.delightedanimation.feature.step1.list

import android.app.Activity
import da.delightedanimation.common.CatClickEvent
import da.delightedanimation.feature.step1.detail.Step1DetailActivity

interface Step1ListRouter {
    fun gotoDetail(item: CatClickEvent)
}

class Step1ListRouterImpl(private val activity: Activity): Step1ListRouter {
    override fun gotoDetail(item: CatClickEvent) {
        Step1DetailActivity.route(activity, item)
    }
}
