package esperer.hexakonal.domain.user.adapter.persistence.adapter

import esperer.hexakonal.domain.user.adapter.persistence.repository.UserRepository
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter

@TransactionalAdapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userConverter: UserConverter
) {
}