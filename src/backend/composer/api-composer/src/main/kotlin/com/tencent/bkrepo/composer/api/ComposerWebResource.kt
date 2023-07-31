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

package com.tencent.bkrepo.composer.api

import com.tencent.bkrepo.common.api.pojo.Response
import com.tencent.bkrepo.common.artifact.api.ArtifactPathVariable
import com.tencent.bkrepo.composer.artifact.ComposerArtifactInfo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Tag(name ="Composer 产品-web接口")
@RequestMapping("/ext")
interface ComposerWebResource {

    @Operation(summary = "composer 包删除接口")
    @DeleteMapping(ComposerArtifactInfo.COMPOSER_EXT_PACKAGE_DELETE)
    fun deletePackage(
        @ArtifactPathVariable composerArtifactInfo: ComposerArtifactInfo,
        @RequestParam packageKey: String
    ): Response<Void>

    @Operation(summary = "composer 版本删除接口")
    @DeleteMapping(ComposerArtifactInfo.COMPOSER_EXT_VERSION_DELETE)
    fun deleteVersion(
        @ArtifactPathVariable composerArtifactInfo: ComposerArtifactInfo,
        @RequestParam packageKey: String,
        @RequestParam version: String?
    ): Response<Void>

    @Operation(summary = "composer 版本详情接口")
    @GetMapping(ComposerArtifactInfo.COMPOSER_EXT_DETAIL)
    fun artifactDetail(
        @ArtifactPathVariable composerArtifactInfo: ComposerArtifactInfo,
        @RequestParam packageKey: String,
        @RequestParam version: String?
    ): Response<Any?>
}
