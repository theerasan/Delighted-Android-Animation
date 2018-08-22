package da.delightedanimation.feature.step3.detail

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View
import da.delightedanimation.R
import da.delightedanimation.databinding.ActivityStep3DetailBinding
import da.delightedanimation.feature.cat.CatItem
import da.delightedanimation.feature.step3.list.CatClickEvent

class Step3DetailActivity : AppCompatActivity() {

    companion object {
        const val CAT_EXTRA = "CAT_EXTRA"

        fun route(activity: Activity, item: CatClickEvent?) {
            val i = Intent(activity, Step3DetailActivity::class.java)

            item?.let {
                val banner = activity.getString(R.string.cat_banner)
                val name = activity.getString(R.string.cat_name)

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
        val binding = DataBindingUtil.setContentView<ActivityStep3DetailBinding>(this, R.layout.activity_step_3_detail)
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
