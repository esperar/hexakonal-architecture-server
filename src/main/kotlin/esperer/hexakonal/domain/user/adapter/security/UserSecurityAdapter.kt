package esperer.hexakonal.domain.user.adapter.security

import esperer.hexakonal.domain.user.application.spi.UserSecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

class UserSecurityAdapter: UserSecurityPort {

    override fun getCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)
}