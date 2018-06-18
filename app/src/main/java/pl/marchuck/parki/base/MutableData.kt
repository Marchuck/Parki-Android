package pl.marchuck.parki.base

import android.arch.lifecycle.MutableLiveData

class MutableData<T>(initValue: T? = null) : MutableLiveData<T>() {

    init {
        set(initValue)
    }

    fun set(value: T?) = setValue(value)

}