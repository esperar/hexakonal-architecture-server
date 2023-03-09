package esperer.hexakonal.domain.user.adapter.presentation

import esperer.hexakonal.domain.user.adapter.presentation.data.request.SignUpRequest
import esperer.hexakonal.domain.user.application.usecase.SignUpUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class UserAuthWebAdapter(
    private val signUpUseCase: SignUpUseCase
) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<Void> =
        signUpUseCase.execute(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}