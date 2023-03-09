package esperer.hexakonal.domain.user.adapter.persistence.adapter

import esperer.hexakonal.domain.user.User
import esperer.hexakonal.domain.user.adapter.persistence.converter.UserConverter
import esperer.hexakonal.domain.user.adapter.persistence.repository.UserRepository
import esperer.hexakonal.domain.user.application.port.UserPort
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@TransactionalAdapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter
): UserPort {
    override fun saveUser(user: User, password: String): User =
        userConverter.toDomain(userRepository.save(userConverter.toEntity(user, password)))

    override fun existsUserByEmail(email: String): Boolean =
        userRepository.existsByEmail(email)

    override fun queryUserByEmail(email: String): User? =
        userRepository.findByEmail(email)?.let { userConverter.toDomain(it) }

    override fun queryUserById(id: UUID): User? =
        userRepository.findByIdOrNull(id)?.let { userConverter.toDomain(it) }

}