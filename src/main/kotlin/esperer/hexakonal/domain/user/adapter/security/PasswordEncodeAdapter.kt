package esperer.hexakonal.domain.user.adapter.security

import esperer.hexakonal.domain.user.application.spi.PasswordEncodePort
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalAdapter
class PasswordEncodeAdapter(
    private val passwordEncoder: PasswordEncoder
): PasswordEncodePort {

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun isPasswordMatch(rawPassword: String, password: String): Boolean =
        passwordEncoder.matches(rawPassword, password)
}