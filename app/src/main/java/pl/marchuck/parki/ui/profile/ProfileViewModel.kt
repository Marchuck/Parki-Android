package pl.marchuck.parki.ui.profile

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

class ProfileViewModel(val repository: ProfileRepository = MockedProfileRepository()) : ViewModel() {

    val editedUserName = ObservableField("")
    val image = ObservableField<String>("")

    val nameFieldVisible = ObservableField(true)
    val nameEditFieldVisible = ObservableField(false)

    init {

        async(UI) {
            val response = repository.fetchProfileData().await()
            editedUserName.set(response.name)
            image.set(response.photo_url)
        }
    }

    fun onEditName() {
        nameFieldVisible.set(false)
        nameEditFieldVisible.set(true)
    }

    fun onEditNameFinish() {
        nameEditFieldVisible.set(false)
        nameFieldVisible.set(true)
    }
}
