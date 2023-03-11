package esperer.hexakonal.domain.post

import java.util.UUID

data class Post(
    val id: UUID,
    val title: String,
    val content: String,
    val userId: UUID,
    val tag: MutableList<String>
)
