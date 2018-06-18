package pl.marchuck.parki.ui.login;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;
import android.support.transition.AutoTransition;
import android.support.transition.Transition;
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
        isVisible(view, isVisible, 10);
    }

    @BindingAdapter({"android:isVisible", "animationDuration"})
    public static void isVisible(View view, boolean isVisible, int animationDuration) {
        Transition transition = new AutoTransition();
        transition.setDuration(animationDuration);

        TransitionManager.beginDelayedTransition((ViewGroup) view.getRootView(), transition);
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
