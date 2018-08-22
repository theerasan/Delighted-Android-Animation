package da.delightedanimation.feature.step3.list

import android.app.Activity
import android.view.View
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step3.detail.Step3DetailActivity

data class CatClickEvent(
        val banner: View,
        val name: View,
        val item: CatItem)

interface Step3ListRouter {
    fun gotoDetail(item: CatClickEvent?)
}

class Step3ListRouterImpl(val activity: Activity): Step3ListRouter {
    override fun gotoDetail(item: CatClickEvent?) {
        Step3DetailActivity.route(activity, item)
    }
}