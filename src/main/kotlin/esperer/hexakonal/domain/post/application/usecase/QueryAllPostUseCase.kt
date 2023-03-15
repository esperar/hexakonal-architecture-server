package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.adapter.presentation.data.response.PostResponse
import esperer.hexakonal.domain.post.application.spi.QueryPostPort
import esperer.hexakonal.domain.user.adapter.presentation.data.response.UserResponse
import esperer.hexakonal.domain.user.application.spi.QueryUserPort
import esperer.hexakonal.domain.user.exception.UserNotFoundException
import esperer.hexakonal.global.annotation.usecase.ReadOnlyUseCase
import java.util.*

@ReadOnlyUseCase
class QueryAllPostUseCase(
    private val queryPostPort: QueryPostPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(): List<PostResponse> =
        queryPostPort.queryAllPost()
            .map { PostResponse(
                postId = it.id,
                title = it.title,
                content = it.content,
                writer = findUserId(it.userId)
            ) }

    fun findUserId(id: UUID): UserResponse =
        queryUserPort.queryUserById(id)
            .let { it ?: throw UserNotFoundException() }
            .let { UserResponse(it.id, it.name, false) }
}