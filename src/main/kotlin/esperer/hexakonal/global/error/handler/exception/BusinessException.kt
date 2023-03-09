package esperer.hexakonal.global.error.handler.exception

import esperer.hexakonal.global.error.ErrorCode

open class BusinessException(val errorCode: ErrorCode): RuntimeException(errorCode.message)