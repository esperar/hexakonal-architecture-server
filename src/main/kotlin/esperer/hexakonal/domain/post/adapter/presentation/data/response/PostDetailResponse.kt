package esperer.hexakonal.domain.post.adapter.presentation.data.response

import esperer.hexakonal.domain.user.adapter.presentation.data.response.UserResponse
import java.util.UUID

data class PostDetailResponse(
    val id: UUID,
    val title: String,
    val content: String,
    val writer: UserResponse,
    val tag: List<String>
)
