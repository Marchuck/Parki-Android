package pl.marchuck.parki.ui.trending

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.marchuck.parki.R
import pl.marchuck.parki.databinding.TrendingFragmentBinding

class TrendingFragment : Fragment() {

    companion object {
        fun newInstance() = TrendingFragment()
    }

    private lateinit var viewModel: TrendingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil
                .inflate<TrendingFragmentBinding>(
                        inflater,
                        R.layout.trending_fragment,
                        container,
                        false
                )
        viewModel = ViewModelProviders.of(this).get(TrendingViewModel::class.java)

        binding.viewModel = viewModel
        return binding.root
    }


}
