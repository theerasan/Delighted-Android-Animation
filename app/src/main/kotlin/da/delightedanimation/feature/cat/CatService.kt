package da.delightedanimation.feature.cat

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import da.delightedanimation.R
import da.delightedanimation.common.toJsonString


interface CatService {
    fun getCats(): List<CatItemDTO>
}

class CatServiceImpl(context: Context) : CatService {
    val resource = context.resources.openRawResource(R.raw.cat_list)!!
    override fun getCats(): List<CatItemDTO> {
        val json = resource.toJsonString()
        val gson = Gson()
        return gson.fromJson(json, object : TypeToken<List<CatItemDTO>>() {}.type) ?: emptyList()
    }
}