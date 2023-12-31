package com.tencent.bkrepo.maven.exception

import com.tencent.bkrepo.common.api.constant.HttpStatus
import com.tencent.bkrepo.common.api.exception.ErrorCodeException
import com.tencent.bkrepo.common.api.message.MessageCode

class MavenMetadataChecksumException(messageCode: MessageCode, vararg params: Any) :
    ErrorCodeException(messageCode = messageCode, status = HttpStatus.OK, params = params)
