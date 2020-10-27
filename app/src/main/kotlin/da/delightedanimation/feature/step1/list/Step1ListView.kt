package da.delightedanimation.feature.step1.list

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import da.delightedanimation.databinding.ActivityStep1Binding
import da.delightedanimation.feature.cat.CatAdapter
import da.delightedanimation.feature.cat.CatItem

interface Step1ListView {
    fun setItems(items: List<CatItem>?)
}

class Step1ListViewImpl(activity: AppCompatActivity, val binding: ActivityStep1Binding) : Step1ListView {

    init {
        with(activity) {
            setSupportActionBar(binding.toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }

        with(binding.catList) {
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(context)
            adapter = CatAdapter(binding.viewModel?.itemClick)
        }
    }

    override fun setItems(items: List<CatItem>?) {
        (binding.catList.adapter as CatAdapter).items = items ?: emptyList()
    }
}

