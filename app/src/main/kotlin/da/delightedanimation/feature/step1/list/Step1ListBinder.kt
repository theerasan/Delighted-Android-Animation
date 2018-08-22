package da.delightedanimation.feature.step1.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityStep1Binding

interface Step1ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step1ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep1Binding) : Step1ListBinder {

    private val viewModel by lazy { activity.viewModel { Step1ListViewModel(activity) } }
    private val view: Step1ListView by lazy { Step1ListViewImpl(activity, binding) }
    private val router: Step1ListRouter by lazy { Step1ListRouterImpl(activity) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { view.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoDetail(it) })
    }
}