package da.delightedanimation.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T = ViewModelProviders.of(this).get(T::class.java)

inline fun <reified T : ViewModel> Fragment.viewModel(): T = ViewModelProviders.of(this).get(T::class.java)

inline fun <reified T : ViewModel> FragmentActivity.viewModel(crossinline initializer: () -> T): T {
    return ViewModelProviders.of(this, vmFactory(initializer)).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.viewModel(crossinline initializer: () -> T): T {
    return ViewModelProviders.of(this, vmFactory(initializer)).get(T::class.java)
}

@Suppress("UNCHECKED_CAST")
inline fun <VM : ViewModel> vmFactory(crossinline initializer: () -> VM) = object : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = initializer() as T
}
