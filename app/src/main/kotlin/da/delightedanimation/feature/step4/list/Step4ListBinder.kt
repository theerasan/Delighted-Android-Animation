package da.delightedanimation.feature.step4.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityStep4Binding

interface Step4ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step4ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep4Binding) : Step4ListBinder {

    private val viewModel by lazy { activity.viewModel { Step4ListViewModel(activity) } }
    private val view: Step4ListView by lazy { Step4ListViewImpl(activity, binding) }
    private val router: Step4ListRouter by lazy { Step4ListRouterImpl(activity) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { view.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoDetail(it) })
    }
}