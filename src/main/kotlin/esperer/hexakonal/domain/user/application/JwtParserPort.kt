package esperer.hexakonal.domain.user.application

import javax.servlet.http.HttpServletRequest

interface JwtParserPort {

    fun parseAccessToken(request: HttpServletRequest): String?
    fun parseRefreshToken(refreshToken: String): String?
    fun authentication(accessToken: String): String?
    fun isRefreshTokenExpired(refreshToken: String): Boolean
}