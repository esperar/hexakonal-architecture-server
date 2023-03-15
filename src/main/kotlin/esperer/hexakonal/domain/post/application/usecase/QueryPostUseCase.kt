package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.adapter.presentation.data.response.PostDetailResponse
import esperer.hexakonal.domain.post.application.spi.QueryPostPort
import esperer.hexakonal.domain.post.exception.PostNotFoundException
import esperer.hexakonal.domain.user.adapter.presentation.data.response.UserResponse
import esperer.hexakonal.domain.user.application.spi.QueryUserPort
import esperer.hexakonal.domain.user.application.spi.UserSecurityPort
import esperer.hexakonal.domain.user.exception.UserNotFoundException
import esperer.hexakonal.global.annotation.adapter.ReadOnlyAdapter
import esperer.hexakonal.global.annotation.usecase.ReadOnlyUseCase
import java.util.UUID

@ReadOnlyUseCase
class QueryPostUseCase(
    private val queryPostPort: QueryPostPort,
    private val queryUserPort: QueryUserPort,
    private val userSecurityPort: UserSecurityPort
) {

    fun execute(postId: UUID): PostDetailResponse {
        val post = queryPostPort.queryPostById(postId) ?: throw PostNotFoundException()
        val user = queryUserPort.queryUserById(post.userId) ?: throw UserNotFoundException()

        return PostDetailResponse(
            id = post.id,
            title = post.title,
            content = post.content,
            writer = UserResponse(
                user.id,
                user.name,
                user.id == userSecurityPort.getCurrentUserId()
            ),
            tag = post.tag
        )

    }
}