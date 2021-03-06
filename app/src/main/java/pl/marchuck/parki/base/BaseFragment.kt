package pl.marchuck.parki.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BoundFragment : Fragment() {
    private var _model: BaseViewModel<out ViewDataBinding>? = null
    private var _params: Bundle? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (_model != null) {
            val binding = _model!!.createBinding(inflater, container!!)
            _model?.setTheBinding(binding!!)
            binding?.root
        } else {
            null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyViewParams()
    }

    private fun applyViewParams() {
        if (_params != null) {

        }
    }

    override fun onResume() {
        super.onResume()

        if (_model != null) {
            _model!!.onResume()
        } else {
        }
    }

    override fun onPause() {
        if (_model != null) {
            _model!!.onPause()
        } else {
        }

        super.onPause()
    }

    fun setModel(model: BaseViewModel<out ViewDataBinding>) {
        _model = model
    }

    fun getModel(): BaseViewModel<out ViewDataBinding>? {
        return _model
    }

    fun setViewParams(params: Bundle?) {
        _params = params
    }

    fun goingBack(): Boolean {
        return _model == null || _model!!.goingBack()
    }


    fun hideKeyboard() {
        (activity as BaseActivity).hideKeyboard()
    }
}