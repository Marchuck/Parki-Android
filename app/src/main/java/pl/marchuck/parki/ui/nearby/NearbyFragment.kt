package pl.marchuck.parki.ui.nearby

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marchuck.parki.R
import pl.marchuck.parki.databinding.NearbyFragmentBinding

class NearbyFragment : Fragment() {

    companion object {
        fun newInstance() = NearbyFragment()
    }

    private lateinit var viewModel: NearbyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil
                .inflate<NearbyFragmentBinding>(inflater, R.layout.nearby_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(NearbyViewModel::class.java)
        viewModel.host = this

        binding.viewModel = viewModel

        return binding.root
    }
}
