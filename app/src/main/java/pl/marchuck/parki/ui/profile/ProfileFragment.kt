package pl.marchuck.parki.ui.profile

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marchuck.parki.R
import pl.marchuck.parki.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }


    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil
                .inflate<ProfileFragmentBinding>(
                        inflater,
                        R.layout.profile_fragment,
                        container,
                        false
                )

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        binding.viewModel = viewModel
        return binding.root

    }


}
