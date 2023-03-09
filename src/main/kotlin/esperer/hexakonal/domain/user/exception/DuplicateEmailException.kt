package esperer.hexakonal.domain.user.exception

import esperer.hexakonal.global.error.ErrorCode
import esperer.hexakonal.global.error.handler.exception.BusinessException

class DuplicateEmailException : BusinessException(ErrorCode.DUPLICATE_EMAIL)