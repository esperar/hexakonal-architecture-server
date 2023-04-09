package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.application.spi.CommandPostPort
import esperer.hexakonal.domain.post.application.spi.QueryPostPort
import esperer.hexakonal.domain.post.exception.PostNotFoundException
import esperer.hexakonal.global.annotation.usecase.TransactionalUseCase
import java.util.UUID

@TransactionalUseCase
class DeletePostUseCase(
    private val commandPostPort: CommandPostPort,
    private val queryPostPort: QueryPostPort
) {

    fun execute(postId: UUID) =
        queryPostPort.queryPostById(postId)
            .let { it ?: throw PostNotFoundException() }
            .let { commandPostPort.deletePost(it) }
}