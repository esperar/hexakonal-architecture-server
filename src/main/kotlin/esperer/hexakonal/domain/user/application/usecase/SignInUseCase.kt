package esperer.hexakonal.domain.user.application.usecase

import esperer.hexakonal.domain.user.adapter.presentation.data.request.SignInRequest
import esperer.hexakonal.domain.user.adapter.presentation.data.response.TokenResponse
import esperer.hexakonal.domain.user.application.port.GenerateJwtPort
import esperer.hexakonal.domain.user.application.port.PasswordEncodePort
import esperer.hexakonal.domain.user.application.port.QueryUserPort
import esperer.hexakonal.domain.user.exception.PasswordMismatchException
import esperer.hexakonal.domain.user.exception.UserNotFoundException
import esperer.hexakonal.global.annotation.usecase.ReadOnlyUseCase

@ReadOnlyUseCase
class SignInUseCase(
    private val queryUserPort: QueryUserPort,
    private val generateJwtPort: GenerateJwtPort,
    private val passwordEncodePort: PasswordEncodePort
) {

    fun execute(request: SignInRequest): TokenResponse {
        val user = queryUserPort.queryUserByEmail(request.email) ?: throw UserNotFoundException()
        if(!passwordEncodePort.isPasswordMatch(request.password, user.password))
            throw PasswordMismatchException()
        return generateJwtPort.generate(user.id)
    }
}