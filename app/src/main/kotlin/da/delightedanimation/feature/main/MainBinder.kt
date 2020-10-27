package da.delightedanimation.feature.main


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import da.delightedanimation.databinding.ActivityMainBinding

interface MainBinder {
    fun bindTo(owner: LifecycleOwner)
}

class MainBinderImpl(activity: AppCompatActivity, binding: ActivityMainBinding) : MainBinder {

    private val viewModel = MainViewModel(activity)
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
