package da.delightedanimation.feature.main

import android.support.v7.widget.LinearLayoutManager
import com.dgreenhalgh.android.simpleitemdecoration.linear.EndOffsetItemDecoration
import com.dgreenhalgh.android.simpleitemdecoration.linear.StartOffsetItemDecoration
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityMainBinding
import da.delightedanimation.feature.main.step.StepAdapter
import da.delightedanimation.feature.main.step.StepItem

interface MainView {
    fun setItems(items: List<StepItem>?)
}

class MainViewImpl(private val binding: ActivityMainBinding) : MainView {

    init {
        with(binding.mainList) {
            setHasFixedSize(false)

            val pixelSize = context.resources.getDimensionPixelSize(R.dimen.gap_xlarge)
            addItemDecoration(StartOffsetItemDecoration(pixelSize))
            addItemDecoration(EndOffsetItemDecoration(pixelSize))

            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = StepAdapter(binding.viewModel?.itemClick)
        }
    }

    override fun setItems(items: List<StepItem>?) {
        (binding.mainList.adapter as StepAdapter).items = items ?: emptyList()
    }
}