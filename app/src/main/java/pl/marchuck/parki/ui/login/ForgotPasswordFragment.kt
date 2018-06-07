package pl.marchuck.parki.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.marchuck.parki.R
import pl.marchuck.parki.databinding.ForgotPasswordFragmentBinding
import pl.marchuck.parki.databinding.LoginFragmentBinding

class ForgotPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotPasswordFragment()
    }

    private lateinit var viewModel: ForgotPasswordViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = DataBindingUtil
                .inflate<ForgotPasswordFragmentBinding>(
                        inflater,
                        R.layout.forgot_password_fragment,
                        container,
                        false
                )
        viewModel = ViewModelProviders.of(this).get(ForgotPasswordViewModel::class.java)
        binding.forgotPasswordViewModel = viewModel
        return binding.root
    }
}
