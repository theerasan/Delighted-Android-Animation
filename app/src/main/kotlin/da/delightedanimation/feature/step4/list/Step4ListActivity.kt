package da.delightedanimation.feature.step4.list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep4Binding

// Step - 04
class Step4ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step4ListActivity::class.java)
            context.startActivity(i)
        }
    }

    private lateinit var binder: Step4ListBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep4Binding>(this, R.layout.activity_step_4)
        binder = Step4ListBinderImpl(this, binding)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
