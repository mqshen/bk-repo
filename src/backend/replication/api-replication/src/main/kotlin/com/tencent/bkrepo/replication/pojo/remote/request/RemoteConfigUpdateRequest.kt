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

package com.tencent.bkrepo.replication.pojo.remote.request

import com.tencent.bkrepo.replication.pojo.request.ReplicaType
import com.tencent.bkrepo.replication.pojo.task.objects.PackageConstraint
import com.tencent.bkrepo.replication.pojo.task.objects.PathConstraint
import com.tencent.bkrepo.replication.pojo.task.setting.ReplicaSetting
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

/**
 * 更新远端集群以及相关信息请求
 */
@Schema(name = "更新远端集群以及相关信息请求")
data class RemoteConfigUpdateRequest(
    // registry与clusterId是二选一
    @Schema(name = "集群id", required = false)
    var clusterId: String? = null,
    @Schema(name = "集群地址", required = false)
    var registry: String? = null,
    @Schema(name = "集群的证书", required = false)
    var certificate: String? = null,
    @Schema(name = "集群认证用户名", required = false)
    var username: String? = null,
    @Schema(name = "集群认证密码", required = false)
    var password: String? = null,
    @Schema(name = "用于执行分发任务时在远程集群进行认证的用户名", required = false)
    var remoteUserUsername: String? = null,
    @Schema(name = "用于执行分发任务时在远程集群进行认证的密码", required = false)
    var remoteUserPassword: String? = null,
    // 异构集群分发时以下remoteProjectId/remoteRepoName不需要
    @Schema(name = "远程项目")
    val remoteProjectId: String? = null,
    @Schema(name = "远程仓库")
    val remoteRepoName: String? = null,
    @Schema(name = "包限制条件", required = false)
    val packageConstraints: List<PackageConstraint>? = null,
    @Schema(name = "路径限制条件", required = false)
    val pathConstraints: List<PathConstraint>? = null,
    @Schema(name = "同步类型", required = false)
    val replicaType: ReplicaType = ReplicaType.REAL_TIME,
    @Schema(name = "任务设置", required = false)
    val setting: ReplicaSetting = ReplicaSetting(),
    @Schema(name = "任务描述", required = false)
    val description: String? = null,
    @Schema(name = "是否启用，默认开启", required = false)
    var enable: Boolean = true
)
