package da.delightedanimation.feature.step1.list

import android.content.Context
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step1.detail.Step1DetailActivity

interface Step1ListRouter {
    fun gotoDetail(item: CatItem?)
}

class Step1ListRouterImpl(val context: Context): Step1ListRouter {
    override fun gotoDetail(item: CatItem?) {
        Step1DetailActivity.route(context, item)
    }
}