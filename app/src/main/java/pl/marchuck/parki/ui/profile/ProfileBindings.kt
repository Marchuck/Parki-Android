package pl.marchuck.parki.ui.profile

import android.app.Activity
import android.databinding.BindingAdapter
import android.support.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import pl.marchuck.parki.base.MutableData


@BindingAdapter("android:isVisible")
fun isVisible(view: View, isVisible: MutableData<Boolean>) {
    TransitionManager.beginDelayedTransition(view.rootView as ViewGroup)
    view.visibility = if (isVisible.value == true) View.VISIBLE else View.GONE
}

@BindingAdapter("android:image")
fun setImage(imageView: ImageView, image: String) {
    TransitionManager.beginDelayedTransition(imageView.rootView as ViewGroup)

    Glide.with(imageView).load(image).into(imageView)
}

@BindingAdapter("android:editFinished")
fun onEditFinished(editText: EditText, viewModel: ProfileViewModel) {
    editText.imeOptions = EditorInfo.IME_ACTION_DONE
    editText.setOnEditorActionListener({ v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            viewModel.onEditNameFinish()
            editText.hideKeyboard()

            return@setOnEditorActionListener true
        }
        false
    })
}


fun View.hideKeyboard() {
    (context.applicationContext.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromInputMethod(windowToken, 0)
}
