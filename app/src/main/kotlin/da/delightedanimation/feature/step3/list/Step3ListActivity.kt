package da.delightedanimation.feature.step3.list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep3Binding

// Step - 03
class Step3ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step3ListActivity::class.java)
            context.startActivity(i)
        }
    }

    private lateinit var binder: Step3ListBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep3Binding>(this, R.layout.activity_step_3)
        binder = Step3ListBinderImpl(this, binding)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
