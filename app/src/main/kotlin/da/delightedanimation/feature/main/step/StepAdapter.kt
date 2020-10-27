package da.delightedanimation.feature.main.step
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import da.delightedanimation.R
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.common.setOnAnimateClickListener
import da.delightedanimation.databinding.ItemStepBinding

class StepAdapter(private val itemClick: SingleLiveEvent<StepItem>?) : RecyclerView.Adapter<StepViewHolder>() {

    var items: List<StepItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_step, parent, false)
        return StepViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long = items[position].imageRes.toLong()
}

class StepViewHolder(itemView: View, private val itemClick: SingleLiveEvent<StepItem>?): RecyclerView.ViewHolder(itemView) {
    private val binding: ItemStepBinding = DataBindingUtil.bind(itemView)!!
    fun bind(item: StepItem) {
        binding.item = item
        binding.root.setOnAnimateClickListener(R.id.banner) {
            itemClick?.postValue(item)
        }
    }
}
