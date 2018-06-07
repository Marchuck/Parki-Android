package pl.marchuck.parki.ui.trending

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.marchuck.parki.R

class TrendingFragment : Fragment() {

    companion object {
        fun newInstance() = TrendingFragment()
    }

    private lateinit var viewModel: TrendingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.trending_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrendingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
