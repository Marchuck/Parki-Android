package pl.marchuck.parki.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), CanNavigateFragments, CanNavigateActivities {

    override fun hideKeyboard() {
        (currentFocus ?: View(this)).apply {
            (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(windowToken, 0)
        }
    }

    override fun navigateTo(klazz: Class<out FragmentActivity>, exitCurrent: Boolean) {
        startActivity(Intent(this, klazz))
        if (exitCurrent) {
            finish()
        }
    }

    override fun navigateTo(f: Fragment, containerId: Int, addToBackStack: Boolean) {
        val trans = supportFragmentManager.beginTransaction()
                .replace(containerId, f)

        if (addToBackStack) {
            trans.addToBackStack(null)
        }
        trans.commitAllowingStateLoss()
    }

    override fun navigateTo(fragment: Fragment, addToBackStack: Boolean) = navigateTo(fragment, getFragmentContainerId(), addToBackStack)

    abstract fun getFragmentContainerId(): Int

    override fun startForResult(intent: Intent, requestCode: Int) {
        startActivityForResult(intent, requestCode)
    }


    override fun onBackPressed() {
        if (hasSomeFragments()) {
            popFragment()
            return
        }
        super.onBackPressed()
    }

    private fun popFragment() {
        supportFragmentManager.popBackStack()
    }

    fun hasSomeFragments() = supportFragmentManager.fragments.size > 0 && supportFragmentManager.fragments[0] != null
}