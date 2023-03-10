package esperer.hexakonal.domain.refresh

import java.util.UUID

data class RefreshToken(
    val refreshToken: String,
    val userId: UUID,
    val expiredAt: Int
)