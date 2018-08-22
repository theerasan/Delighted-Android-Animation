package da.delightedanimation.feature.step4.list

import android.app.Activity
import android.view.View
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step4.detail.Step4DetailActivity

data class CatClickEvent(
        val banner: View,
        val name: View,
        val item: CatItem)

interface Step4ListRouter {
    fun gotoDetail(item: CatClickEvent?)
}

class Step4ListRouterImpl(val activity: Activity): Step4ListRouter {
    override fun gotoDetail(item: CatClickEvent?) {
        Step4DetailActivity.route(activity, item)
    }
}