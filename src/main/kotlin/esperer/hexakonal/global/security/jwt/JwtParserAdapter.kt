package esperer.hexakonal.global.security.jwt

import org.springframework.stereotype.Component

@Component
class JwtParserAdapter(
    private val jwtProperties
) {
}