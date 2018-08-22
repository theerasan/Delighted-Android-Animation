package da.delightedanimation.feature.step5.list

import android.app.Activity
import android.view.View
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step5.detail.Step5DetailActivity

data class CatClickEvent(
        val banner: View,
        val name: View,
        val item: CatItem)

interface Step5ListRouter {
    fun gotoDetail(item: CatClickEvent?)
}

class Step5ListRouterImpl(val activity: Activity): Step5ListRouter {
    override fun gotoDetail(item: CatClickEvent?) {
        Step5DetailActivity.route(activity, item)
    }
}