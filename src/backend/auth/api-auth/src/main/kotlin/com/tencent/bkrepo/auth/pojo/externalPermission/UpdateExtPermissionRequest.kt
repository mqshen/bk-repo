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

package com.tencent.bkrepo.auth.pojo.externalPermission

import com.tencent.bkrepo.common.operate.api.annotation.Sensitive
import com.tencent.bkrepo.common.operate.api.handler.MaskPartMapValue
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

@Schema(name = "更新外部权限请求")
data class UpdateExtPermissionRequest(
    @Schema(name = "id")
    val id: String,
    @Schema(name = "外部权限回调地址")
    val url: String? = null,
    @Schema(name = "请求头")
    @Sensitive(handler = MaskPartMapValue::class)
    val headers: Map<String, String>? = null,
    @Schema(name = "项目id")
    val projectId: String? = null,
    @Schema(name = "仓库名")
    val repoName: String? = null,
    @Schema(name = "生效微服务")
    val scope: String? = null,
    @Schema(name = "平台账号白名单，白名单内不会校验外部权限")
    val platformWhiteList: List<String>? = null,
    @Schema(name = "是否启用")
    val enabled: Boolean? = null
)
