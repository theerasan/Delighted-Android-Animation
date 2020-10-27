package da.delightedanimation.feature.step1.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1Binding

// Step - 01
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

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
