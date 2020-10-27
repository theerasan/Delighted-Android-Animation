package da.delightedanimation.feature.step1.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1DetailBinding
import da.delightedanimation.feature.cat.CatItem

class Step1DetailActivity : AppCompatActivity() {

    companion object {
        const val CAT_EXTRA = "CAT_EXTRA"

        fun route(context: Context, item: CatItem?) {
            val i = Intent(context, Step1DetailActivity::class.java)
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
