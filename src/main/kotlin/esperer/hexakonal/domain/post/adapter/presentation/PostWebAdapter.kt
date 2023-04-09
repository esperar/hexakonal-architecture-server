package esperer.hexakonal.domain.post.adapter.presentation

import esperer.hexakonal.domain.post.adapter.presentation.data.request.CreatePostRequest
import esperer.hexakonal.domain.post.adapter.presentation.data.response.PostDetailResponse
import esperer.hexakonal.domain.post.adapter.presentation.data.response.PostResponse
import esperer.hexakonal.domain.post.application.usecase.DeletePostUseCase
import esperer.hexakonal.domain.post.application.usecase.QueryAllPostUseCase
import esperer.hexakonal.domain.post.application.usecase.QueryPostUseCase
import esperer.hexakonal.domain.post.application.usecase.SavePostUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/post")
class PostWebAdapter(
    private val savePostUseCase: SavePostUseCase,
    private val queryPostUseCase: QueryPostUseCase,
    private val queryAllPostUseCase: QueryAllPostUseCase,
    private val deletePostUseCase: DeletePostUseCase
) {

    @PostMapping
    fun savePost(@RequestBody request: CreatePostRequest): ResponseEntity<Void> =
        savePostUseCase.execute(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build()}

    @GetMapping("/{post_id}")
    fun getPostDetail(@PathVariable("post_id") postId: UUID): ResponseEntity<PostDetailResponse> =
        queryPostUseCase.execute(postId)
            .let { ResponseEntity.ok(it) }

    @GetMapping
    fun getAllPost(): ResponseEntity<List<PostResponse>> =
        queryAllPostUseCase.execute()
            .let { ResponseEntity.ok(it) }

    @DeleteMapping("/{post_id}")
    fun deletePost(@PathVariable("post_id") postId: UUID): ResponseEntity<Void> =
        deletePostUseCase.execute(postId)
            .let { ResponseEntity.ok().build() }

}