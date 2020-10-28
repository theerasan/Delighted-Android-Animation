package da.delightedanimation.common

import android.view.View
import da.delightedanimation.feature.cat.CatItem

data class CatClickEvent(val banner: View, val name: View, val item: CatItem)
