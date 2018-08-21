package da.delightedanimation.feature.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binder: MainBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binder = MainBinderImpl(this, binding)
        binder.bindTo(this)
    }
}
