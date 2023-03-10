package esperer.hexakonal.domain.user.exception

import esperer.hexakonal.global.error.ErrorCode
import esperer.hexakonal.global.error.handler.exception.BusinessException

class UserNotFoundException : BusinessException(ErrorCode.USER_NOT_FOUND)