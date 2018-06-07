package pl.marchuck.parki.ui.login

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.Single
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import pl.marchuck.parki.base.NavigationService
import pl.marchuck.parki.ext.await
import java.util.concurrent.TimeUnit

class LoginViewModel : ViewModel() {

    var navigationService: NavigationService? = null

    val email = ObservableField<String>()
    val emailError = ObservableField<String>(null)

    val password = ObservableField<String>()
    val passwordError = ObservableField<String>(null)

    val progressVisible = ObservableField(false)

    fun onLoginClick() {

        navigationService?.hideKeyboard()

        if (email.get()?.trim()?.isValidEmail() != true) {
            emailError.set("Email invalid")
            return
        } else {
            emailError.set(null)
        }
        if (password.get()?.trim()?.isValidPassword() != true) {
            passwordError.set("Password too short")
            return
        } else {
            passwordError.set(null)
        }

        progressVisible.set(true)

        async(UI) {
            val isLogged = Single.just("Hello").delay(1, TimeUnit.SECONDS) //todo refactor and inject it

            isLogged.await()

            progressVisible.set(false)

            navigationService?.openHomeView()
        }
    }

    fun onForgotPasswordClick() {
        navigationService?.openForgotPasswordView()
    }

    fun String.isValidEmail() = true//this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    fun String.isValidPassword() = true//this.isNotEmpty() && length > 6 //todo validate password from validator (inject it)
}
