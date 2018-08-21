package da.delightedanimation.feature.main.step

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import da.delightedanimation.common.toJsonString
import da.delightedanimation.R


interface StepService {
    fun getStep(): List<StepItemDTO>
}

class StepServiceImpl(context: Context) : StepService {
    val resource = context.resources.openRawResource(R.raw.main_list)!!
    override fun getStep(): List<StepItemDTO> {
        val json = resource.toJsonString()
        val gson = Gson()
        return gson.fromJson(json, object : TypeToken<List<StepItemDTO>>() {}.type) ?: emptyList()
    }
}