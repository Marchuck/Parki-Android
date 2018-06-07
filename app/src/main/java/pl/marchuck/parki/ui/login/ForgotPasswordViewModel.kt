package pl.marchuck.parki.ui.login

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField

class ForgotPasswordViewModel : ViewModel() {


    val email = ObservableField<String>()
    val emailError = ObservableField<String>(null)

    val progressVisible = ObservableField(false)

    fun onPasswordReset() {

    }
}
