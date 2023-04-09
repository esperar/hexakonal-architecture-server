package esperer.hexakonal.domain.post.application.spi

import esperer.hexakonal.domain.post.Post

interface CommandPostPort {
    fun savePost(post: Post): Post
    fun deletePort(post: Post)
}