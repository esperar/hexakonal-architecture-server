package esperer.hexakonal.domain.user.adapter.presentation.data.request

data class SignInRequest(
    val email: String,
    val password: String
)