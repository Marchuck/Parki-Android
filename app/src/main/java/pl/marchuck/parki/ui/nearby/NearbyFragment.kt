package pl.marchuck.parki.ui.nearby

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.marchuck.parki.R

class NearbyFragment : Fragment() {

    companion object {
        fun newInstance() = NearbyFragment()
    }

    private lateinit var viewModel: NearbyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.nearby_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NearbyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
