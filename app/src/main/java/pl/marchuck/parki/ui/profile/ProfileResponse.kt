package pl.marchuck.parki.ui.profile

data class ProfileResponse(
        val name: String,
        val surname: String,
        val email: String,
        val photo_url: String = "",
        val video_url: String,
        val friends: List<FriendReference>
)