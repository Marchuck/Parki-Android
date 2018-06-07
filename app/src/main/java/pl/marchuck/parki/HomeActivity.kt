package pl.marchuck.parki

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import pl.marchuck.parki.base.BaseActivity
import pl.marchuck.parki.ui.nearby.NearbyFragment
import pl.marchuck.parki.ui.profile.ProfileFragment
import pl.marchuck.parki.ui.trending.TrendingFragment


class HomeActivity : BaseActivity() {

    override fun getFragmentContainerId() = R.id.home_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomBar.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.action_trending -> {
                    openFragment(TrendingFragment.newInstance())
                }
                R.id.action_nearby -> {
                    openFragment(NearbyFragment.newInstance())
                }
                R.id.action_profile -> {
                    openFragment(ProfileFragment.newInstance())
                }
            }
            false
        }

        if (savedInstanceState == null) {
            bottomBar.menu.getItem(0).isChecked = true
            openFragment(TrendingFragment.newInstance())
        }
    }

    private fun openFragment(fragment: Fragment) = navigateTo(fragment, false)
}
