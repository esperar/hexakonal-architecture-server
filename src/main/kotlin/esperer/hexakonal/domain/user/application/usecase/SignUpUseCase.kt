package esperer.hexakonal.domain.user.application.usecase

import esperer.hexakonal.domain.user.adapter.presentation.data.request.SignUpRequest
import esperer.hexakonal.domain.user.application.port.CommandAccountPort
import esperer.hexakonal.domain.user.application.port.PasswordEncodePort
import esperer.hexakonal.domain.user.application.port.QueryUserPort
import esperer.hexakonal.global.annotation.usecase.TransactionalUseCase

@TransactionalUseCase
class SignUpUseCase(
    private val commandAccountPort: CommandAccountPort,
    private val queryUserPort: QueryUserPort,
    private val passwordEncodePort: PasswordEncodePort
) {

    fun execute(request: SignUpRequest): UUID {
        if(queryAccountPort)
    }
}