package esperer.hexakonal.domain.user.adapter.persistence.converter

import esperer.hexakonal.domain.user.User
import esperer.hexakonal.domain.user.adapter.persistence.entity.UserEntity
import esperer.hexakonal.domain.user.adapter.presentation.data.enums.Authority
import org.springframework.stereotype.Component
import java.util.Collections

@Component
class UserConverter {

    fun toEntity(user: User, password: String): UserEntity =
        user.let {
            UserEntity(
                id = it.id,
                email = it.email,
                password = password,
                name = it.name,
                authority = Collections.singletonList(Authority.ROLE_USER)
            )
        }

    fun toDomain(userEntity: UserEntity): User =
        userEntity.let {
            User(
                id = it.id,
                email = it.email,
                password = it.password,
                name = it.name,
            )
        }
}