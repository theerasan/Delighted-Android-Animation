package da.delightedanimation.feature.cat

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Handler
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import da.delightedanimation.R
import da.delightedanimation.common.CatClickEvent
import da.delightedanimation.common.SingleLiveEvent
import da.delightedanimation.databinding.ItemCatBinding

class CatAdapter(private val itemClick: SingleLiveEvent<CatClickEvent>?) :
    RecyclerView.Adapter<CatViewHolder>() {

    var items: List<CatItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemId(position: Int): Long = items[position].imageRes.toLong()
}

class CatViewHolder(itemView: View, private val itemClick: SingleLiveEvent<CatClickEvent>?) :
    RecyclerView.ViewHolder(itemView) {
    private val binding: ItemCatBinding = DataBindingUtil.bind(itemView)!!
    fun bind(item: CatItem) {
        binding.item = item

        binding.root.onAnimationClick {
            itemClick?.postValue(CatClickEvent(binding.banner, binding.name, item))
        }
    }
}

@SuppressLint("ClickableViewAccessibility")
private fun View.onAnimationClick(onClick: (View) -> Unit) {
    this.setOnClickListener { view ->
        Handler().postDelayed({
            onClick.invoke(view)
        }, 400)
    }

    this.setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                v.animate().cancel()
                v.animate().scaleY(0.96f)
                    .scaleX(0.96f)
                    .setDuration(200)
                    .start()
                false
            }
            MotionEvent.ACTION_UP -> {
                val xBigScale = ObjectAnimator.ofFloat(v, "scaleX", 1.03f)
                xBigScale.setDuration(160).repeatCount = 0

                val yBigScale = ObjectAnimator.ofFloat(v, "scaleY", 1.03f)
                yBigScale.setDuration(160).repeatCount = 0

                val xSmallScale = ObjectAnimator.ofFloat(v, "scaleX", 0.985f)
                xSmallScale.setDuration(140).repeatCount = 0

                val ySmallScale = ObjectAnimator.ofFloat(v, "scaleY", 0.985f)
                ySmallScale.setDuration(140).repeatCount = 0

                val xNormalScale = ObjectAnimator.ofFloat(v, "scaleX", 1f)
                xNormalScale.setDuration(70).repeatCount = 0

                val yNormalScale = ObjectAnimator.ofFloat(v, "scaleY", 1f)
                yNormalScale.setDuration(70).repeatCount = 0

                val animateSet = AnimatorSet()
                animateSet.play(xBigScale).with(yBigScale)
                animateSet.play(xSmallScale).after(xBigScale)
                animateSet.play(ySmallScale).after(yBigScale)
                animateSet.play(xNormalScale).after(xSmallScale)
                animateSet.play(yNormalScale).after(ySmallScale)
                animateSet.start()

                false

            }
            MotionEvent.ACTION_CANCEL -> {
                v.animate()
                    .scaleY(1f)
                    .scaleX(1f)
                    .setDuration(200)
                    .start()

                true
            }
            else -> {
                true
            }
        }
    }
}
