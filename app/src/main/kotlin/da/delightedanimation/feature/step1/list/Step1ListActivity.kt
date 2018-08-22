package da.delightedanimation.feature.step1.list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1Binding

class Step1ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step1ListActivity::class.java)
            context.startActivity(i)
        }
    }

    private lateinit var binder: Step1ListBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep1Binding>(this, R.layout.activity_step_1)
        binder = Step1ListBinderImpl(this, binding)
        binder.bindTo(this)
    }
}
