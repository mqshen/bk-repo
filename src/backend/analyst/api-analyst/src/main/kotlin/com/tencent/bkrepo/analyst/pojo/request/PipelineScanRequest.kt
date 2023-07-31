/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2022 THL A29 Limited, a Tencent company.  All rights reserved.
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

package com.tencent.bkrepo.analyst.pojo.request

import com.tencent.bkrepo.common.artifact.pojo.RepositoryType
import com.tencent.bkrepo.common.query.model.Rule
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

@Schema(name = "流水线触发扫描请求")
data class PipelineScanRequest(
    @Schema(name = "项目id")
    val projectId: String,
    @Schema(name = "流水线id")
    val pid: String? = null,
    @Schema(name = "构建id")
    val bid: String? = null,
    @Schema(name = "构建号")
    val buildNo: String? = null,
    @Schema(name = "流水线名")
    val pipelineName: String? = null,
    @Schema(name = "使用的插件名")
    val pluginName: String? = null,
    @Schema(name = "扫描方案id，未指定时会创建一个generic类型的默认方案")
    val planId: String? = null,
    @Schema(name = "未指定planId时默认创建的扫描方案类型")
    val planType: String = RepositoryType.GENERIC.name,
    @Schema(name = "未指定planId时默认创建的扫描方案使用的扫描器")
    val scanner: String? = null,
    @Schema(name = "扫描文件匹配规则")
    val rule: Rule,
    @Schema(name = "用于通知扫描结果的企业微信群机器人")
    val weworkBotUrl: String? = null,
    @Schema(name = "用于通知扫描结果的企业微信群机器人会话，多个id用|分隔")
    val chatIds: String? = null
)
