package da.delightedanimation.feature.cat

import java.io.Serializable

data class CatItemDTO(val name: String,
                      val detail: String,
                      val image: String)

data class CatItem(val name: String,
                       val detail: String,
                       val imageRes: Int): Serializable