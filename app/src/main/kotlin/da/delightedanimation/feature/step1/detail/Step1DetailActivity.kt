package da.delightedanimation.feature.step1.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import kotlinx.android.synthetic.main.activity_step_1.*

class Step1DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_1)
        setSupportActionBar(toolbar)

    }

}
