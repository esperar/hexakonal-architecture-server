package esperer.hexakonal.domain.post.exception

import esperer.hexakonal.global.error.ErrorCode
import esperer.hexakonal.global.error.handler.exception.BusinessException

class PostNotFoundException : BusinessException(ErrorCode.POST_NOT_FOUND)