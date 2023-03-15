package esperer.hexakonal.domain.user.adapter.presentation.data.response

import java.util.*

data class UserResponse(
    val userId: UUID,
    val name: String,
    val inMine: Boolean
)
