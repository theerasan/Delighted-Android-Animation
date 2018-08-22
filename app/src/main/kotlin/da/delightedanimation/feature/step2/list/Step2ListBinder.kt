package da.delightedanimation.feature.step2.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityStep2Binding

interface Step2ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step2ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep2Binding) : Step2ListBinder {

    private val viewModel by lazy { activity.viewModel { Step2ListViewModel(activity) } }
    private val view: Step2ListView by lazy { Step2ListViewImpl(activity, binding) }
    private val router: Step2ListRouter by lazy { Step2ListRouterImpl(activity) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { view.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoDetail(it) })
    }
}