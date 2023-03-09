package esperer.hexakonal.domain.user.adapter.presentation.data.request

import esperer.hexakonal.domain.user.User
import java.util.*

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String
)

fun SignUpRequest.toDomain(): User =
    User(id = UUID.randomUUID(), email = email, password = password, name = name)
