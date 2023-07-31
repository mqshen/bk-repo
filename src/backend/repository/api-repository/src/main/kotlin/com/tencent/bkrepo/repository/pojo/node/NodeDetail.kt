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

package com.tencent.bkrepo.repository.pojo.node

import com.tencent.bkrepo.common.artifact.constant.METADATA_KEY_PACKAGE_NAME
import com.tencent.bkrepo.common.artifact.constant.METADATA_KEY_PACKAGE_VERSION
import com.tencent.bkrepo.repository.pojo.metadata.MetadataModel
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

/**
 * 节点详细信息
 */
@Schema(name = "节点详细信息")
data class NodeDetail(
    @Schema(name = "节点基本信息")
    @Deprecated("冗余信息，nodeInfo信息已包含在NodeDetail字段中，nodeInfo将来会删除")
    val nodeInfo: NodeInfo,

    @Schema(name = "创建者")
    val createdBy: String = nodeInfo.createdBy,
    @Schema(name = "创建时间")
    val createdDate: String = nodeInfo.createdDate,
    @Schema(name = "修改者")
    val lastModifiedBy: String = nodeInfo.lastModifiedBy,
    @Schema(name = "修改时间")
    val lastModifiedDate: String = nodeInfo.lastModifiedDate,
    @Schema(name = "访问时间")
    val lastAccessDate: String? = nodeInfo.lastAccessDate,

    @Schema(name = "是否为文件夹")
    val folder: Boolean = nodeInfo.folder,
    @Schema(name = "路径")
    val path: String = nodeInfo.path,
    @Schema(name = "资源名称")
    val name: String = nodeInfo.name,
    @Schema(name = "完整路径")
    val fullPath: String = nodeInfo.fullPath,
    @Schema(name = "文件大小，单位byte")
    val size: Long = nodeInfo.size,
    @Schema(name = "文件sha256")
    val sha256: String? = nodeInfo.sha256,
    @Schema(name = "文件md5")
    val md5: String? = nodeInfo.md5,
    @Schema(name = "元数据")
    val metadata: Map<String, Any> = nodeInfo.metadata.orEmpty(),
    @Schema(name = "元数据")
    val nodeMetadata: List<MetadataModel> = nodeInfo.nodeMetadata.orEmpty(),
    @Schema(name = "所属项目id")
    val projectId: String = nodeInfo.projectId,
    @Schema(name = "所属仓库名称")
    val repoName: String = nodeInfo.repoName,
    @Schema(name = "集群信息")
    val clusterNames: Set<String>? = nodeInfo.clusterNames
) {
    /**
     * 获取node所属package的name
     */
    fun packageName() = metadata[METADATA_KEY_PACKAGE_NAME]?.toString()

    /**
     * 获取node所属package的版本
     */
    fun packageVersion() = metadata[METADATA_KEY_PACKAGE_VERSION]?.toString()
}
