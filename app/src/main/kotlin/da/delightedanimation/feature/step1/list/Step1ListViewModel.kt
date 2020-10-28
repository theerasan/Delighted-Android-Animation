package da.delightedanimation.feature.step1.list

import android.content.Context
import androidx.lifecycle.ViewModel
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.common.CatClickEvent
import da.delightedanimation.feature.cat.CatRepository
import da.delightedanimation.feature.cat.CatRepositoryImpl

class Step1ListViewModel(context: Context): ViewModel() {
    private val repository: CatRepository = CatRepositoryImpl(context)
    val items = repository.getCats()
    val itemClick = SingleLiveEvent<CatClickEvent>()
}
