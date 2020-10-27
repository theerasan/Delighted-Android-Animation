package da.delightedanimation.common


import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imageResource")
fun setImageResource(imageView: ImageView, imageResource: Int) {
    if (imageResource > 0) {
        imageView.setImageResource(imageResource)
    }
}
