package esperer.hexakonal.domain.post.adapter.presentation.data.request

data class UpdatePostRequest(
    val title: String,
    val content: String,
    val tag: MutableList<String>,
    val thumbnailUrl: String?
)
