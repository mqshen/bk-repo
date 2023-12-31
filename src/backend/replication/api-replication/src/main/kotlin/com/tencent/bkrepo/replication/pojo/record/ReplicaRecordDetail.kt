/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
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

package com.tencent.bkrepo.replication.pojo.record

import com.tencent.bkrepo.common.artifact.pojo.RepositoryType
import com.tencent.bkrepo.replication.pojo.task.objects.PackageConstraint
import com.tencent.bkrepo.replication.pojo.task.objects.PathConstraint
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty
import java.time.LocalDateTime

@Schema(name = "同步任务执行记录详情")
data class ReplicaRecordDetail(
    @Schema(name = "详情id")
    var id: String,
    @Schema(name = "记录id")
    var recordId: String,
    @Schema(name = "本地集群名称")
    var localCluster: String,
    @Schema(name = "远程集群名称")
    var remoteCluster: String,
    @Schema(name = "本地仓库名称")
    var localRepoName: String,
    @Schema(name = "仓库类型")
    val repoType: RepositoryType,
    @Schema(name = "包限制")
    var packageConstraint: PackageConstraint? = null,
    @Schema(name = "路径名称")
    var pathConstraint: PathConstraint? = null,
    @Schema(name = "运行状态")
    var status: ExecutionStatus,
    @Schema(name = "同步进度")
    var progress: ReplicaProgress,
    @Schema(name = "开始时间")
    var startTime: LocalDateTime,
    @Schema(name = "结束时间")
    var endTime: LocalDateTime? = null,
    @Schema(name = "错误原因，未执行或执行成功则为null")
    var errorReason: String? = null
)
