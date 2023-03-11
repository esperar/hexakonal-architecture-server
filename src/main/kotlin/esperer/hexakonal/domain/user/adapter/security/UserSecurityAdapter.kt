package esperer.hexakonal.domain.user.adapter.security

import esperer.hexakonal.domain.user.application.spi.UserSecurityPort
import esperer.hexakonal.global.annotation.adapter.ReadOnlyAdapter
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@ReadOnlyAdapter
class UserSecurityAdapter: UserSecurityPort {

    override fun getCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)
}