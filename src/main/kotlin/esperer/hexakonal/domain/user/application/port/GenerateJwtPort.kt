package esperer.hexakonal.domain.user.application.port

import esperer.hexakonal.domain.user.adapter.presentation.data.response.TokenResponse
import java.util.UUID

interface GenerateJwtPort {

    fun generate(userId: UUID): TokenResponse
}