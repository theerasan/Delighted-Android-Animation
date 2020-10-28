package da.delightedanimation.feature.step1.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.databinding.DataBindingUtil
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep1DetailBinding
import da.delightedanimation.common.CatClickEvent
import da.delightedanimation.feature.cat.CatItem

class Step1DetailActivity : AppCompatActivity() {

    companion object {
        const val CAT_EXTRA = "CAT_EXTRA"

        fun route(activity: Activity, item: CatClickEvent) {
            val i = Intent(activity, Step1DetailActivity::class.java)
            item.let {
                val banner = activity.getString(R.string.cat_banner)
                val name = activity.getString(R.string.cat_name)
                // androidx.core.util.Pair
                val bannerPair: Pair<View, String> = Pair(item.banner, banner)
                val namePair: Pair<View, String> = Pair(item.name, name)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, bannerPair, namePair)

                i.putExtra(CAT_EXTRA, it.item)
                activity.startActivity(i, options.toBundle())
            }
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
