package esperer.hexakonal.domain.user.application.spi

import java.util.UUID

interface UserSecurityPort {
    fun getCurrentUserId(): UUID
}