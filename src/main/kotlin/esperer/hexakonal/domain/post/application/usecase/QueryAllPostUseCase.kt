package esperer.hexakonal.domain.post.application.usecase

import esperer.hexakonal.domain.post.application.spi.QueryPostPort
import esperer.hexakonal.domain.user.application.spi.QueryUserPort
import esperer.hexakonal.global.annotation.usecase.ReadOnlyUseCase

@ReadOnlyUseCase
class QueryAllPostUseCase(
    private val queryPostPort: QueryPostPort,
    private val queryUserPort: QueryUserPort
) {


}