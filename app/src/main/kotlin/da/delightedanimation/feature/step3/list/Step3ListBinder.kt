package da.delightedanimation.feature.step3.list

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityStep3Binding

interface Step3ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step3ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep3Binding) : Step3ListBinder {

    private val viewModel by lazy { activity.viewModel { Step3ListViewModel(activity) } }
    private val view: Step3ListView by lazy { Step3ListViewImpl(activity, binding) }
    private val router: Step3ListRouter by lazy { Step3ListRouterImpl(activity) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { view.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoDetail(it) })
    }
}