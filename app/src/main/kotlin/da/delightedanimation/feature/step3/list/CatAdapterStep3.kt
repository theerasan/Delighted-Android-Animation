package da.delightedanimation.feature.step3.list
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import da.delightedanimation.R
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.databinding.ItemCatStep3Binding
import da.delightedanimation.feature.cat.CatItem

class CatAdapterStep3(private val itemClick: SingleLiveEvent<CatClickEvent>?) : RecyclerView.Adapter<CatViewHolder>() {

    var items: List<CatItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat_step_3, parent, false)
        return CatViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long = items[position].imageRes.toLong()
}

class CatViewHolder(itemView: View, private val itemClick: SingleLiveEvent<CatClickEvent>?): RecyclerView.ViewHolder(itemView) {
    private val binding: ItemCatStep3Binding = DataBindingUtil.bind(itemView)!!
    fun bind(item: CatItem) {
        binding.item = item
        binding.root.setOnClickListener {
            itemClick?.postValue(CatClickEvent(binding.banner, binding.name, item))
        }

        binding.banner
    }
}