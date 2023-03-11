package esperer.hexakonal.domain.user.application.spi

interface PasswordEncodePort {

    fun passwordEncode(password: String): String
    fun isPasswordMatch(rawPassword: String, password: String): Boolean
}