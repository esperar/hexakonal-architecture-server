package esperer.hexakonal.domain.post.adapter.persistence.repository

import esperer.hexakonal.domain.post.Post
import esperer.hexakonal.domain.post.adapter.persistence.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PostRepository : JpaRepository<PostEntity, UUID> {
}