package da.delightedanimation.feature.main

import android.content.Context
import da.delightedanimation.R
import da.delightedanimation.feature.main.step.StepItem
import da.delightedanimation.feature.step1.list.Step1ListActivity
import da.delightedanimation.feature.step2.list.Step2ListActivity

interface MainRouter {
    fun gotoNextStep(item: StepItem?)
}

class MainRouterImpl(val context: Context) : MainRouter {
    override fun gotoNextStep(item: StepItem?) {
        item?.let {
            when(it.imageRes) {
                R.drawable.mobile_conf_001 -> Step1ListActivity.route(context)
                R.drawable.mobile_conf_002 -> Step2ListActivity.route(context)
            }
        }
    }
}