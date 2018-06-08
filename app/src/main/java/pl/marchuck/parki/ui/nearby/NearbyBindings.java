package pl.marchuck.parki.ui.nearby;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.TextView;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import pl.marchuck.parki.ui.login.LoginBindings;

import static pl.marchuck.parki.ui.login.LoginBindings.isVisible;

public class NearbyBindings {

    @BindingAdapter("android:pulsatorState")
    public static void setPulsatorState(PulsatorLayout view, PulsatorState state) {
        if (state == PulsatorState.STARTED) {
            view.start();
        } else if (state == PulsatorState.STOPPED) {
            view.stop();
        }
    }

    @BindingAdapter("android:visibilityFromText")
    public static void setVisibilityFromText(TextView view, String text) {
        boolean shouldBeVisible = !TextUtils.isEmpty(text);
        isVisible(view, shouldBeVisible);
    }
}
