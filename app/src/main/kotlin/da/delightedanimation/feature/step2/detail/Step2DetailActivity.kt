package da.delightedanimation.feature.step2.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1DetailBinding
import da.delightedanimation.feature.cat.CatItem

class Step2DetailActivity : AppCompatActivity() {

    companion object {
        const val CAT_EXTRA = "CAT_EXTRA"

        fun route(context: Context, item: CatItem?) {
            val i = Intent(context, Step2DetailActivity::class.java)
            i.putExtra(CAT_EXTRA, item)
            context.startActivity(i)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStep1DetailBinding>(this, R.layout.activity_step_1_detail)
        val catItem = intent.extras.get(CAT_EXTRA) as CatItem
        binding.item = catItem
        with(this) {
            setSupportActionBar(binding.catToolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
