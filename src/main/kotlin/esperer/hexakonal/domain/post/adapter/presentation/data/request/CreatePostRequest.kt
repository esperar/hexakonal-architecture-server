package esperer.hexakonal.domain.post.adapter.presentation.data.request

data class CreatePostRequest(
    val title: String,
    val content: String,
    val tag: MutableList<String>
)
