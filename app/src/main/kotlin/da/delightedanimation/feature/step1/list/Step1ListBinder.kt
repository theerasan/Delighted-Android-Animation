package da.delightedanimation.feature.step1.list


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import da.delightedanimation.databinding.ActivityStep1Binding

interface Step1ListBinder {
    fun bindTo(owner: LifecycleOwner)
}

class Step1ListBinderImpl(activity: AppCompatActivity, binding: ActivityStep1Binding) : Step1ListBinder {

    private val viewModel = Step1ListViewModel(activity)
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
