package esperer.hexakonal.global.security.jwt

import esperer.hexakonal.domain.refresh.adapter.persistence.entity.RefreshTokenEntity
import esperer.hexakonal.domain.refresh.adapter.persistence.repository.RefreshTokenRepository
import esperer.hexakonal.domain.user.adapter.presentation.data.response.TokenResponse
import esperer.hexakonal.domain.user.application.port.GenerateJwtPort
import esperer.hexakonal.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.security.Key
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateJwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
): GenerateJwtPort {

    override fun generate(userId: UUID): TokenResponse {
        val accessToken = generateAccessToken(userId, jwtProperties.accessSecret)
        val refreshToken = generateRefreshToken(userId, jwtProperties.refreshSecret)
        val expiredAt = getAccessTokenExpiredAt()
        refreshTokenRepository.save(RefreshTokenEntity(refreshToken, userId, jwtProperties.refreshExp))
        return TokenResponse(accessToken, refreshToken, expiredAt)
    }

    private fun generateAccessToken(userId: UUID, secret: Key): String =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(userId.toString())
            .claim("type", JwtProperties.accessType)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun generateRefreshToken(userId: UUID, secret: Key): String =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(userId.toString())
            .claim("type", JwtProperties.refreshType)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun getAccessTokenExpiredAt(): LocalDateTime =
        LocalDateTime.now().plusSeconds(jwtProperties.accessExp.toLong())

}