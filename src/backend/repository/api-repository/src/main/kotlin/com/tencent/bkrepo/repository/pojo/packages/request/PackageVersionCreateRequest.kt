/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2020 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.tencent.bkrepo.repository.pojo.packages.request

import com.tencent.bkrepo.repository.pojo.metadata.MetadataModel
import com.tencent.bkrepo.repository.pojo.packages.PackageType
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

data class PackageVersionCreateRequest(
    @Schema(name = "项目id")
    val projectId: String,
    @Schema(name = "仓库名称")
    val repoName: String,
    @Schema(name = "包名称")
    val packageName: String,
    @Schema(name = "包唯一标识符")
    val packageKey: String,
    @Schema(name = "包类型")
    val packageType: PackageType,
    @Schema(name = "包简要描述")
    val packageDescription: String? = null,
    @Schema(name = "包版本标签")
    val versionTag: Map<String, String>? = null,
    @Schema(name = "包扩展字段")
    val packageExtension: Map<String, Any>? = null,
    @Schema(name = "版本名称")
    val versionName: String,
    @Schema(name = "版本大小")
    val size: Long,
    @Schema(name = "版本描述文件路径")
    var manifestPath: String? = null,
    @Schema(name = "版本内容文件路径")
    var artifactPath: String? = null,
    @Schema(name = "版本构件阶段")
    val stageTag: List<String>? = null,
    @Schema(name = "版本元数据")
    @Deprecated("仅用于兼容旧接口", replaceWith = ReplaceWith("packageMetadata"))
    val metadata: Map<String, Any>? = null,
    @Schema(name = "版本元数据")
    val packageMetadata: List<MetadataModel>? = null,
    @Schema(name = "标签")
    val tags: List<String>? = null,
    @Schema(name = "版本扩展字段")
    val extension: Map<String, Any>? = null,
    @Schema(name = "是否允许覆盖")
    val overwrite: Boolean = false,
    @Schema(name = "创建人")
    val createdBy: String
)
