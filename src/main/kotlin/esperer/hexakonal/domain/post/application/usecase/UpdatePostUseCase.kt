package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.adapter.presentation.data.request.UpdatePostRequest
import esperer.hexakonal.domain.post.application.spi.CommandPostPort
import esperer.hexakonal.domain.post.application.spi.QueryPostPort
import esperer.hexakonal.domain.post.exception.PostNotFoundException
import esperer.hexakonal.global.annotation.usecase.TransactionalUseCase
import java.util.UUID

@TransactionalUseCase
class UpdatePostUseCase(
    private val commandPostPort: CommandPostPort,
    private val queryPostPort: QueryPostPort
) {

    fun execute(postId: UUID, request: UpdatePostRequest): UUID =
        queryPostPort.queryPostById(postId)
            .let { it ?: throw PostNotFoundException() }
            .let { commandPostPort.savePost(
                it.copy(title = request.title, content = request.content, tag = request.tag)
            ) }.id

}