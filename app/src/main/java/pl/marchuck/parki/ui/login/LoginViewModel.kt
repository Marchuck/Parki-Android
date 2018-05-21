package pl.marchuck.parki.ui.login

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import io.reactivex.Single
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import pl.marchuck.parki.ext.await
import java.util.concurrent.TimeUnit

class LoginViewModel : ViewModel() {

    val email = ObservableField<String>()
    val password = ObservableField<String>()

    fun onLoginClick() {
        println("onLoginClick() ${email.get()}  : ${password.get()}")


        async(UI) {
            var isLogged = Single.just("Hello").delay(1, TimeUnit.SECONDS)

            email.set(" ${isLogged.await()}")

            isLogged = Single.just("how").delay(1, TimeUnit.SECONDS)

            email.set("result: ${isLogged.await()}")
            isLogged = Single.just("are").delay(1, TimeUnit.SECONDS)

            email.set("${isLogged.await()}")

            isLogged = Single.just("you?").delay(1, TimeUnit.SECONDS)

            email.set("${isLogged.await()}")

        }


    }
}
