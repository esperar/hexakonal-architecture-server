package esperer.hexakonal.domain.post.adapter.persistence

import esperer.hexakonal.domain.post.Post
import esperer.hexakonal.domain.post.adapter.persistence.converter.PostConverter
import esperer.hexakonal.domain.post.adapter.persistence.repository.PostRepository
import esperer.hexakonal.domain.post.application.spi.PostPort
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter

@TransactionalAdapter
class PostPersistenceAdapter(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter
): PostPort {

    override fun savePost(post: Post): Post =
        postConverter.toDomain(postRepository.save(postConverter.toEntity(post)))

}