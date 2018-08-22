package da.delightedanimation.feature.step4.list

import android.arch.lifecycle.ViewModel
import android.content.Context
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.feature.cat.CatRepository
import da.delightedanimation.feature.cat.CatRepositoryImpl

class Step4ListViewModel(context: Context): ViewModel() {
    private val repository: CatRepository = CatRepositoryImpl(context)
    val items = repository.getCats()
    val itemClick = SingleLiveEvent<CatClickEvent>()
}