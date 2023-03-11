package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.application.spi.CommandPostPort
import esperer.hexakonal.global.annotation.usecase.TransactionalUseCase

@TransactionalUseCase
class SavePostUseCase(
    private val commandPostPort: CommandPostPort,
) {
}