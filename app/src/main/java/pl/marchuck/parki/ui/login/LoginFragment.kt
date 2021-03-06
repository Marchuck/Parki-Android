package pl.marchuck.parki.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marchuck.parki.R
import pl.marchuck.parki.base.BoundFragment
import pl.marchuck.parki.base.CanNavigateActivities
import pl.marchuck.parki.base.CanNavigateFragments
import pl.marchuck.parki.base.NavigationService
import pl.marchuck.parki.databinding.LoginFragmentBinding


class LoginFragment : BoundFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = DataBindingUtil
                .inflate<LoginFragmentBinding>(
                        inflater,
                        R.layout.login_fragment,
                        container,
                        false
                )
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.navigationService = NavigationService(
                activity as CanNavigateFragments,
                activity as CanNavigateActivities)
        binding.loginViewModel = viewModel
        return binding.root
    }
}
