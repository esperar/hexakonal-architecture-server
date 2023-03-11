package esperer.hexakonal.domain.post.adapter.persistence

import esperer.hexakonal.domain.post.adapter.persistence.repository.PostRepository
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter

@TransactionalAdapter
class PostPersistenceAdapter(
    private val postRepository: PostRepository,
) {
}