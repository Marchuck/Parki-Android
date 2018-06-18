package pl.marchuck.parki.ui.nearby;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import pl.marchuck.parki.base.MutableData;

import static pl.marchuck.parki.ui.login.LoginBindings.isVisible;

public class NearbyBindings {

    @BindingAdapter("android:pulsatorState")
    public static void setPulsatorState(PulsatorLayout view, MutableData<PulsatorState> state) {
        if (state.getValue() == PulsatorState.STARTED) {
            view.start();
        } else if (state.getValue() == PulsatorState.STOPPED) {
            view.stop();
        }
    }

    @BindingAdapter("android:visibilityFromText")
    public static void setVisibilityFromText(TextView view, MutableData<String> text) {
        boolean shouldBeVisible = !TextUtils.isEmpty(text.getValue());
        isVisible(view, shouldBeVisible);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, MutableData<String> text) {
        view.setText(text.getValue());
    }
}
