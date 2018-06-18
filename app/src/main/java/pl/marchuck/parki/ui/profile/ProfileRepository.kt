package pl.marchuck.parki.ui.profile

import kotlinx.coroutines.experimental.Deferred

interface ProfileRepository {

    fun fetchProfileData() : Deferred<ProfileResponse>

}