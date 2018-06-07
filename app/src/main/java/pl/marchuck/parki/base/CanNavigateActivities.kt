package pl.marchuck.parki.base

import android.content.Intent
import android.support.v4.app.FragmentActivity

interface CanNavigateActivities {

    fun navigateTo(klazz: Class<out FragmentActivity>, exitCurrent: Boolean)

    fun startForResult(intent: Intent, requestCode: Int)

    fun hideKeyboard()
}
