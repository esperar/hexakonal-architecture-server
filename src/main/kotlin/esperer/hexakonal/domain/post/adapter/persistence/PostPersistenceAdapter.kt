package esperer.hexakonal.domain.post.adapter.persistence

import esperer.hexakonal.domain.post.Post
import esperer.hexakonal.domain.post.adapter.persistence.converter.PostConverter
import esperer.hexakonal.domain.post.adapter.persistence.repository.PostRepository
import esperer.hexakonal.domain.post.application.spi.PostPort
import esperer.hexakonal.domain.post.exception.PostNotFoundException
import esperer.hexakonal.global.annotation.adapter.TransactionalAdapter
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@TransactionalAdapter
class PostPersistenceAdapter(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter
): PostPort {

    override fun savePost(post: Post): Post =
        postConverter.toDomain(postRepository.save(postConverter.toEntity(post)))

    override fun queryPostById(postId: UUID): Post? =
        postRepository.findByIdOrNull(postId)?.let { postConverter.toDomain(it) }

    override fun queryAllPost(pageRequest: PageRequest): List<Post> =
        postRepository.findAll().map { postConverter.toDomain(it)}
}