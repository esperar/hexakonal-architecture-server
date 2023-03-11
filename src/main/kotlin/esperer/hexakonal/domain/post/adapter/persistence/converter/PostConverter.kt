package esperer.hexakonal.domain.post.adapter.persistence.converter

import esperer.hexakonal.domain.post.Post
import esperer.hexakonal.domain.post.adapter.persistence.entity.PostEntity
import esperer.hexakonal.domain.post.adapter.persistence.repository.PostRepository
import esperer.hexakonal.domain.post.exception.PostNotFoundException
import esperer.hexakonal.domain.user.adapter.persistence.repository.UserRepository
import esperer.hexakonal.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PostConverter(
    private val userRepository: UserRepository
) {

    fun toEntity(post: Post): PostEntity {
        val userEntity = userRepository.findByIdOrNull(post.id) ?: throw UserNotFoundException()
        return post.let {
            PostEntity(
                id = it.id,
                title = it.title,
                content = it.content,
                user = userEntity,
                tag = it.tag
            )
        }
    }

    fun toDomain(post: PostEntity): Post {
        return post.let {
            Post(
                id = it.id,
                title = it.title,
                content = it.content,
                userId = it.user.id,
                tag = it.tag
            )
        }
    }
}