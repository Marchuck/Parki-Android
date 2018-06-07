package pl.marchuck.parki.base

import android.support.v4.app.Fragment

interface CanNavigateFragments {

    fun navigateTo(fragment: Fragment, addToBackStack: Boolean)
}