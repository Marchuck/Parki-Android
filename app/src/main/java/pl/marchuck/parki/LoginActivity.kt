package pl.marchuck.parki

import android.os.Bundle
import pl.marchuck.parki.base.BaseActivity
import pl.marchuck.parki.ui.login.LoginFragment

class LoginActivity : BaseActivity() {

    override fun getFragmentContainerId() = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            navigateTo(LoginFragment.newInstance(), true)
        }
    }


}
