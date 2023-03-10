package esperer.hexakonal.domain.refresh.exception

import esperer.hexakonal.global.error.ErrorCode
import esperer.hexakonal.global.error.handler.exception.BusinessException

class InvalidTokenException : BusinessException(ErrorCode.INVALID_TOKEN)