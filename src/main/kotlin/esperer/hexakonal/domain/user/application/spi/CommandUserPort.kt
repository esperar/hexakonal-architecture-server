package esperer.hexakonal.domain.user.application.spi

import esperer.hexakonal.domain.user.User

interface CommandUserPort {
    fun saveUser(user: User, password: String): User
}