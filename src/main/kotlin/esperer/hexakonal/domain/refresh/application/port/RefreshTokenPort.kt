package esperer.hexakonal.domain.refresh.application.port

import esperer.hexakonal.domain.refresh.RefreshToken

interface RefreshTokenPort {

    fun queryByRefreshToken(refreshToken: String): RefreshToken
}