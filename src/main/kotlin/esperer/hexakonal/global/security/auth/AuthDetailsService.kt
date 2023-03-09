package esperer.hexakonal.global.security.auth

import esperer.hexakonal.domain.user.adapter.persistence.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails =
        AuthDetails(userRepository.findByIdOrNull(UUID.fromString(username)) ?: throw RuntimeException())

}