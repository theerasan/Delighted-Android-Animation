package da.delightedanimation.common

import android.databinding.BindingAdapter
import android.widget.ImageView

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, imageResource: Int) {
    if (imageResource > 0) {
        imageView.setImageResource(imageResource)
    }
}