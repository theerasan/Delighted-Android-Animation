package da.delightedanimation.feature.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.common.viewModel
import da.delightedanimation.databinding.ActivityMainBinding

interface MainBinder {
    fun bindTo(owner: LifecycleOwner)
}

class MainBinderImpl(activity: AppCompatActivity, binding: ActivityMainBinding) : MainBinder {

    private val viewModel by lazy { activity.viewModel { MainViewModel(activity) } }
    private val mainView: MainView by lazy { MainViewImpl(binding) }
    private val router: MainRouter by lazy { MainRouterImpl(binding.root.context) }

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.items.observe(owner, Observer { mainView.setItems(it) })
        viewModel.itemClick.observe(owner, Observer { router.gotoNextStep(it) })
    }
}
