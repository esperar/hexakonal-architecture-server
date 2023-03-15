package esperer.hexakonal.domain.post.application.spi

import esperer.hexakonal.domain.post.Post
import org.springframework.data.domain.PageRequest
import java.util.UUID

interface QueryPostPort {

    fun queryPostById(postId: UUID): Post?
    fun queryAllPost(pageRequest: PageRequest): List<Post>
}