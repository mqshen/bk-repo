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

package com.tencent.bkrepo.repository.pojo.packages

import com.tencent.bkrepo.repository.pojo.metadata.MetadataModel
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty
import java.time.LocalDateTime

/**
 * 包信息
 */
@Schema(name = "包信息")
data class PackageVersion(
    @Schema(name = "创建者")
    val createdBy: String,
    @Schema(name = "创建时间")
    val createdDate: LocalDateTime,
    @Schema(name = "修改者")
    val lastModifiedBy: String,
    @Schema(name = "修改时间")
    val lastModifiedDate: LocalDateTime,

    @Schema(name = "包版本")
    val name: String,
    @Schema(name = "包大小")
    val size: Long,
    @Schema(name = "下载次数")
    var downloads: Long,
    @Schema(name = "制品晋级阶段")
    val stageTag: List<String>,
    @Schema(name = "元数据")
    val metadata: Map<String, Any>,
    @Schema(name = "元数据")
    val packageMetadata: List<MetadataModel>,
    @Schema(name = "标签")
    val tags: List<String>,
    @Schema(name = "扩展字段")
    val extension: Map<String, Any>,
    @Schema(name = "包内容文件路径")
    val contentPath: String? = null,
    @Schema(name = "清单文件路径")
    val manifestPath: String? = null,
    @Schema(name = "集群名")
    val clusterNames: Set<String>? = null
)
