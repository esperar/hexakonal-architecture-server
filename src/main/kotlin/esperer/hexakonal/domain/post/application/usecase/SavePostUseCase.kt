package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.Post
import esperer.hexakonal.domain.post.adapter.presentation.data.request.CreatePostRequest
import esperer.hexakonal.domain.post.application.spi.CommandPostPort
import esperer.hexakonal.domain.user.application.spi.UserSecurityPort
import esperer.hexakonal.global.annotation.usecase.TransactionalUseCase
import java.util.*
import kotlin.contracts.contract

@TransactionalUseCase
class SavePostUseCase(
    private val commandPostPort: CommandPostPort,
    private val userSecurityPort: UserSecurityPort
) {

    fun execute(request: CreatePostRequest): UUID {
        val post = request.let {
            Post(
                id = UUID.randomUUID(),
                title = it.title,
                content = it.content,
                userId = userSecurityPort.getCurrentUserId(),
                tag = it.tag

            )
        }
        return commandPostPort.savePost(post).id
    }
}