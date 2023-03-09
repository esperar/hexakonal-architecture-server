package esperer.hexakonal.domain.user.application.port

import esperer.hexakonal.domain.user.User

interface CommandUserPort {
    fun saveUser(user: User, password: String): User
}