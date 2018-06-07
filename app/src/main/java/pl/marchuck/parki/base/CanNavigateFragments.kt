package pl.marchuck.parki.base

interface CanNavigateFragments {

    fun navigateTo(f: android.support.v4.app.Fragment, containerId: Int, addToBackStack: Boolean)

    fun navigateTo(f: android.support.v4.app.Fragment, addToBackStack: Boolean)
}