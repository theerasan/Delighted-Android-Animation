package da.delightedanimation.feature.step5.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityStep5Binding

interface Step5ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step5ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep5Binding) : Step5ListBinder {

    private val viewModel by lazy { activity.viewModel { Step5ListViewModel(activity) } }
    private val view: Step5ListView by lazy { Step5ListViewImpl(activity, binding) }
    private val router: Step5ListRouter by lazy { Step5ListRouterImpl(activity) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { view.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoDetail(it) })
    }
}