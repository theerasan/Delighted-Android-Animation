package da.delightedanimation.feature.main

import android.content.Context
import androidx.lifecycle.ViewModel
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.feature.main.step.StepItem
import da.delightedanimation.feature.main.step.StepRepository
import da.delightedanimation.feature.main.step.StepRepositoryImpl

class MainViewModel(context: Context): ViewModel() {
    private val repository: StepRepository = StepRepositoryImpl(context)
    val items = repository.getSteps()
    val itemClick = SingleLiveEvent<StepItem>()
}
