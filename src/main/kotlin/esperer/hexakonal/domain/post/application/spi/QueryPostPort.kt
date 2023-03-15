package esperer.hexakonal.domain.post.application.spi

import esperer.hexakonal.domain.post.Post
import java.util.UUID

interface QueryPostPort {

    fun queryPostById(postId: UUID): Post?

}