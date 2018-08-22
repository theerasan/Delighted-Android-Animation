package da.delightedanimation.feature.step5.list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep5Binding

// Step - 05
class Step5ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step5ListActivity::class.java)
            context.startActivity(i)
        }
    }

    private lateinit var binder: Step5ListBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep5Binding>(this, R.layout.activity_step_5)
        binder = Step5ListBinderImpl(this, binding)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
