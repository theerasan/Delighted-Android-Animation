package da.delightedanimation.feature.cat

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import da.delightedanimation.R

interface CatRepository {
    fun getCats(): LiveData<List<CatItem>>
}

class CatRepositoryImpl(context: Context) : CatRepository {

    private val steps = MutableLiveData<List<CatItem>>()
    private val service: CatService = CatServiceImpl(context)

    init {
        steps.value = emptyList()
    }

    override fun getCats(): LiveData<List<CatItem>> {
        steps.value = service.getCats().map {
            CatItem(name = it.name,
                    detail = it.detail,
                    imageRes = getImageRes(it.image))
        }
        return steps
    }

    private fun getImageRes(imageRes: String?): Int = when(imageRes) {
        "cat_001" -> R.drawable.cat_001
        "cat_002" -> R.drawable.cat_002
        "cat_003" -> R.drawable.cat_003
        "cat_004" -> R.drawable.cat_004
        "cat_005" -> R.drawable.cat_005
        "cat_006" -> R.drawable.cat_006
        "cat_007" -> R.drawable.cat_007
        else -> R.drawable.cat_001
    }

}