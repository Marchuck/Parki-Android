package pl.marchuck.parki.ui.login;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class LoginBindings {

    @BindingAdapter("android:error")
    public static void setError(TextInputLayout view, CharSequence sequence) {
        view.setError(sequence);
    }

    @BindingAdapter("android:isVisible")
    public static void isVisible(View view, boolean isVisible) {
        TransitionManager.beginDelayedTransition((ViewGroup) view.getRootView());
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
