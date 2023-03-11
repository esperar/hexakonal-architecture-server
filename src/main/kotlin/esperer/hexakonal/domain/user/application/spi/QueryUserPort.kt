package esperer.hexakonal.domain.user.application.spi

import esperer.hexakonal.domain.user.User
import java.util.UUID

interface QueryUserPort {

    fun existsUserByEmail(email: String): Boolean
    fun queryUserByEmail(email: String): User?
    fun queryUserById(id: UUID): User?
}