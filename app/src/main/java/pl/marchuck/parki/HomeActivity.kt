package pl.marchuck.parki

import android.os.Bundle
import android.support.v4.app.Fragment
import com.roughike.bottombar.BottomBar
import pl.marchuck.parki.base.BaseActivity
import pl.marchuck.parki.ui.nearby.NearbyFragment
import pl.marchuck.parki.ui.profile.ProfileFragment
import pl.marchuck.parki.ui.trending.TrendingFragment


class HomeActivity : BaseActivity() {

    override fun getFragmentContainerId() = R.id.home_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val bottomBar = findViewById<BottomBar>(R.id.bottomBar)

        bottomBar.setOnTabSelectListener { itemId ->
            when (itemId) {
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
        }

        if (savedInstanceState == null) {
            bottomBar.getTabAtPosition(0).performClick()

            openFragment(TrendingFragment.newInstance())
        }
    }

    private fun openFragment(fragment: Fragment) = navigateTo(fragment, false)
}

