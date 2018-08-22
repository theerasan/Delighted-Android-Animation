package da.delightedanimation.feature.step2.list

import android.content.Context
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step2.detail.Step2DetailActivity

interface Step2ListRouter {
    fun gotoDetail(item: CatItem?)
}

class Step2ListRouterImpl(val context: Context): Step2ListRouter {
    override fun gotoDetail(item: CatItem?) {
        Step2DetailActivity.route(context, item)
    }
}