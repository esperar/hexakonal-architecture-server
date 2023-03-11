package esperer.hexakonal.domain.refresh.application.spi

import esperer.hexakonal.domain.refresh.RefreshToken

interface RefreshTokenPort {

    fun queryByRefreshToken(refreshToken: String): RefreshToken
}