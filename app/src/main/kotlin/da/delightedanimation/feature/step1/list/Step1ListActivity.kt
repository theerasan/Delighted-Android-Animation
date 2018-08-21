package da.delightedanimation.feature.step1.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import kotlinx.android.synthetic.main.activity_step_1.*

class Step1ListActivity : AppCompatActivity() {
    companion object {
        fun route(context: Context) {
            val i = Intent(context, Step1ListActivity::class.java)
            context.startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_1)
        setSupportActionBar(toolbar)

    }
}
