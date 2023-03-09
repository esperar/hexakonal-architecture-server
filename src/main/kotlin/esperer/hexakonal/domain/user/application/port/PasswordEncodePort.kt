package esperer.hexakonal.domain.user.application.port

interface PasswordEncodePort {

    fun passwordEncode(password: String): String
    fun isPasswordMatch(rawPassword: String, password: String): Boolean
}