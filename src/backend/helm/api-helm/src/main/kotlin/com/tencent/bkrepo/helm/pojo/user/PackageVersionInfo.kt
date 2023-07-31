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

package com.tencent.bkrepo.helm.pojo.user

import com.tencent.bkrepo.repository.pojo.metadata.MetadataModel
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name ="npm版本详情页返回包装模型")
data class PackageVersionInfo(
    @Schema(name = "基础信息")
    val basic: BasicInfo,
    @Schema(name = "元数据信息")
    val metadata: List<MetadataModel>
)

@Tag(name ="基础信息")
data class BasicInfo(
    @Schema(name = "版本字段")
    val version: String,
    @Schema(name = "完整路径")
    val fullPath: String,
    @Schema(name = "文件大小，单位byte")
    val size: Long,
    @Schema(name = "文件sha256")
    val sha256: String,
    @Schema(name = "文件md5")
    val md5: String,
    @Schema(name = "晋级状态标签")
    val stageTag: List<String>,
    @Schema(name = "所属项目id")
    val projectId: String,
    @Schema(name = "所属仓库名称")
    val repoName: String,
    @Schema(name = "下载次数")
    val downloadCount: Long,
    @Schema(name = "创建者")
    val createdBy: String,
    @Schema(name = "创建时间")
    val createdDate: String,
    @Schema(name = "修改者")
    val lastModifiedBy: String,
    @Schema(name = "修改时间")
    val lastModifiedDate: String
)
