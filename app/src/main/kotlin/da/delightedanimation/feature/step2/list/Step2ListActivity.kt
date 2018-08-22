package da.delightedanimation.feature.step2.list

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep2Binding

// Step - 02
class Step2ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step2ListActivity::class.java)
            context.startActivity(i)
        }
    }

    private lateinit var binder: Step2ListBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep2Binding>(this, R.layout.activity_step_2)
        binder = Step2ListBinderImpl(this, binding)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
