package esperer.hexakonal.domain.user.application.usecase

import esperer.hexakonal.domain.user.application.port.GenerateJwtPort
import esperer.hexakonal.domain.user.application.port.PasswordEncodePort
import esperer.hexakonal.domain.user.application.port.QueryUserPort
import esperer.hexakonal.global.annotation.usecase.ReadOnlyUseCase

@ReadOnlyUseCase
class SignInUseCase(
    private val queryUserPort: QueryUserPort,
    private val generateJwtPort: GenerateJwtPort,
    private val passwordEncodePort: PasswordEncodePort
) {
}