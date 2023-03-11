package esperer.hexakonal.domain.refresh.adapter.persistence

import esperer.hexakonal.domain.refresh.RefreshToken
import esperer.hexakonal.domain.refresh.adapter.persistence.entity.toDomain
import esperer.hexakonal.domain.refresh.adapter.persistence.repository.RefreshTokenRepository
import esperer.hexakonal.domain.refresh.application.spi.RefreshTokenPort
import esperer.hexakonal.domain.refresh.exception.InvalidTokenException
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter
import org.springframework.data.repository.findByIdOrNull

@TransactionalAdapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository
): RefreshTokenPort {

    override fun queryByRefreshToken(refreshToken: String): RefreshToken =
        refreshTokenRepository.findByIdOrNull(refreshToken)
            .let { it ?: throw InvalidTokenException() }.toDomain()
}