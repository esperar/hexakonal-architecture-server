package esperer.hexakonal.domain.refresh.adapter.persistence.entity

import esperer.hexakonal.domain.refresh.RefreshToken
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.UUID
import java.util.concurrent.TimeUnit

@RedisHash("refresh_token")
data class RefreshTokenEntity(
    @Id
    val refreshToken: String,
    val userId: UUID,
    @TimeToLive(unit = TimeUnit.SECONDS)
    val expiredAt: Int
)

fun RefreshTokenEntity.toDomain() = RefreshToken(refreshToken = refreshToken, userId = userId, expiredAt = expiredAt)