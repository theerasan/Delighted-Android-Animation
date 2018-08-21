package da.delightedanimation.feature.main

import android.support.v7.widget.LinearLayoutManager
import da.delightedanimation.databinding.ActivityMainBinding
import da.delightedanimation.feature.main.step.StepAdapter
import da.delightedanimation.feature.main.step.StepItem

interface MainView {
    fun setItems(items: List<StepItem>?)
}

class MainViewImpl(val binding: ActivityMainBinding) : MainView {

    init {
        with(binding.mainList) {
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = StepAdapter(binding.viewModel?.itemClick)
        }
    }

    override fun setItems(items: List<StepItem>?) {
        (binding.mainList.adapter as StepAdapter).items = items ?: emptyList()
    }
}