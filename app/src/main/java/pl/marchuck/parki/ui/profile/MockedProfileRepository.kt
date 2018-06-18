package pl.marchuck.parki.ui.profile

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import java.util.*

class MockedProfileRepository : ProfileRepository {

    @Volatile
    var cachedResponse: ProfileResponse? = null

    override fun fetchProfileData(): Deferred<ProfileResponse> {
        return async { fetchMockProfile() }
    }

    private suspend fun fetchMockProfile(): ProfileResponse {

        if (cachedResponse != null) {
            return cachedResponse!!
        }

        randomDelay()

        val lastResponse = ProfileResponse(
                name = "Janusz",
                surname = "Paleta",
                email = "janusz@op.pl",
                photo_url = "https://vignette.wikia.nocookie.net/serialblokekipa/images/2/2a/Wies%C5%82aw_Paleta_2.png/revision/latest?cb=20160508142258&path-prefix=pl",
                video_url = "",
                friends = emptyList())

        cachedResponse = lastResponse

        return lastResponse
    }


    suspend fun randomDelay() {
        val random = Random()
        delay(1300 + random.nextInt(500))
    }
}