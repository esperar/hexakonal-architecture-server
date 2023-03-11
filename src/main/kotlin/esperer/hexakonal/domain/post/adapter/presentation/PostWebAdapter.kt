package esperer.hexakonal.domain.post.adapter.presentation

import esperer.hexakonal.domain.post.adapter.presentation.data.request.CreatePostRequest
import esperer.hexakonal.domain.post.application.usecase.SavePostUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostWebAdapter(
    private val savePostUseCase: SavePostUseCase
) {

    @PostMapping
    fun savePost(@RequestBody request: CreatePostRequest): ResponseEntity<Void> =
        savePostUseCase.execute(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build()}

}