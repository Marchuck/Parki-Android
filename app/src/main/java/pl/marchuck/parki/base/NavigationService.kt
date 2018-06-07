package pl.marchuck.parki.base

import pl.marchuck.parki.HomeActivity
import pl.marchuck.parki.ui.login.ForgotPasswordFragment

class NavigationService(val switcher: CanNavigateFragments,
                        val activity: CanNavigateActivities) {

    fun openForgotPasswordView() {
        switcher.navigateTo(ForgotPasswordFragment.newInstance(), true)
    }

    fun openHomeView() {
        activity.navigateTo(HomeActivity::class.java, true)
    }

    fun hideKeyboard() = activity.hideKeyboard()

}