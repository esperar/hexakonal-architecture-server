package esperer.hexakonal.global.security.jwt

import esperer.hexakonal.global.security.jwt.properties.JwtProperties
import org.springframework.stereotype.Component

@Component
class JwtParserAdapter(
    private val jwtProperties: JwtProperties
) {
}