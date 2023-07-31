/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bkrepo.webhook.pojo

import com.tencent.bkrepo.common.artifact.event.base.EventType
import com.tencent.bkrepo.webhook.constant.WebHookRequestStatus
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty
import java.time.LocalDateTime

@Schema(name = "WebHook日志信息")
data class WebHookLog(
    @Schema(name = "id")
    val id: String,
    @Schema(name = "WebHook回调地址")
    val webHookUrl: String,
    @Schema(name = "触发事件")
    val triggeredEvent: EventType,
    @Schema(name = "请求头")
    val requestHeaders: Map<String, String>,
    @Schema(name = "请求载荷")
    val requestPayload: String,
    @Schema(name = "请求状态")
    val status: WebHookRequestStatus,
    @Schema(name = "响应头")
    val responseHeaders: Map<String, String>? = null,
    @Schema(name = "响应体")
    val responseBody: String? = null,
    @Schema(name = "请求耗时")
    val requestDuration: Long,
    @Schema(name = "请求时间")
    val requestTime: LocalDateTime,
    @Schema(name = "错误信息")
    val errorMsg: String? = null
)
