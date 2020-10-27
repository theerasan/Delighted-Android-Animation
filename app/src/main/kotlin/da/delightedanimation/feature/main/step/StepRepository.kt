package da.delightedanimation.feature.main.step

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import da.delightedanimation.R

interface StepRepository {
    fun getSteps(): LiveData<List<StepItem>>
}

class StepRepositoryImpl(context: Context) : StepRepository {

    private val steps = MutableLiveData<List<StepItem>>()
    private val service: StepService = StepServiceImpl(context)

    init {
        steps.value = emptyList()
    }

    override fun getSteps(): LiveData<List<StepItem>> {
        steps.value = service.getStep().map {
            StepItem(step = it.step,
                    title = it.title,
                    imageRes = getImageRes(it.image))
        }
        return steps
    }

    private fun getImageRes(imageRes: String?): Int = when(imageRes) {
        "mobile_conf_001" -> R.drawable.mobile_conf_001
        "mobile_conf_002" -> R.drawable.mobile_conf_002
        "mobile_conf_003" -> R.drawable.mobile_conf_003
        "mobile_conf_004" -> R.drawable.mobile_conf_004
        "mobile_conf_005" -> R.drawable.mobile_conf_005
        else -> R.drawable.mobile_conf_001
    }

}
