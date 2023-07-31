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

package com.tencent.bkrepo.npm.pojo.user

import com.fasterxml.jackson.annotation.JsonInclude
import com.tencent.bkrepo.npm.pojo.module.des.ModuleDepsInfo
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag

@Tag(name ="npm页面返回包装模型")
data class PackageInfo(
    @Schema(name = "包名称")
    val name: String,
    @Schema(name = "包描述信息")
    val description: String,
    @Schema(name = "包的readme信息")
    val readme: String,
    @Schema(name = "包的tag信息")
    val currentTags: List<TagsInfo>,
    @Schema(name = "包的版本信息")
    val versions: List<TagsInfo>,
    @Schema(name = "包的主要贡献者信息")
    val maintainers: List<MaintainerInfo>,
    @Schema(name = "包的下载量信息")
    val downloadCount: List<DownloadCount>,
    @Schema(name = "包的依赖信息")
    val dependencies: List<DependenciesInfo>,
    @Schema(name = "包的开发依赖信息")
    val devDependencies: List<DependenciesInfo>,
    @Schema(name = "包的被依赖信息")
    val dependents: List<ModuleDepsInfo>
)

data class TagsInfo(
    @Schema(name = "tag")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val tags: String? = null,
    @Schema(name = "版本")
    val version: String,
    @Schema(name = "时间")
    val time: String
)

data class MaintainerInfo(
    @Schema(name = "贡献者名称")
    val name: String,
    @Schema(name = "邮箱")
    val email: String
)

data class DependenciesInfo(
    @Schema(name = "包的名称")
    val name: String,
    @Schema(name = "版本")
    val version: String
)

data class DownloadCount(
    @Schema(name = "时间段")
    val description: String,
    @Schema(name = "下载量")
    val count: Long
)
