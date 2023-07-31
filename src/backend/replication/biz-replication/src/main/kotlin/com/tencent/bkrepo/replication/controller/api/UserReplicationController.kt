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

package com.tencent.bkrepo.replication.controller.api

import com.tencent.bkrepo.common.api.pojo.Response
import com.tencent.bkrepo.common.security.permission.Principal
import com.tencent.bkrepo.common.security.permission.PrincipalType
import com.tencent.bkrepo.common.service.util.ResponseBuilder
import com.tencent.bkrepo.replication.pojo.dispatch.ReplicaNodeDispatchConfigInfo
import com.tencent.bkrepo.replication.pojo.dispatch.request.ReplicaNodeDispatchConfigCreateRequest
import com.tencent.bkrepo.replication.pojo.dispatch.request.ReplicaNodeDispatchConfigUpdateRequest
import com.tencent.bkrepo.replication.pojo.ext.CheckRepoDifferenceRequest
import com.tencent.bkrepo.replication.service.ReplicaExtService
import com.tencent.bkrepo.replication.service.ReplicaNodeDispatchService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name ="同步ext接口")
@Principal(type = PrincipalType.ADMIN)
@RestController
@RequestMapping("/ext/")
class UserReplicationController(
    private val replicaExtService: ReplicaExtService,
    private val replicaNodeDispatchService: ReplicaNodeDispatchService
) {


    /**
     * 检查两个仓库之间的差异
     */
    @PostMapping("/find/repo/difference")
    fun findRepoDifference(
        @RequestBody request: CheckRepoDifferenceRequest
    ): Response<Any> {
        return ResponseBuilder.success(replicaExtService.findRepoDifference(request))
    }

    /**
     * 同步两个仓库之间的差异
     */
    @PostMapping("/sync/repo/difference")
    fun syncRepoDifference(
        @RequestBody request: CheckRepoDifferenceRequest
    ): Response<Any> {
        return ResponseBuilder.success(replicaExtService.syncRepoDifference(request))
    }


    /**
     * 新增分发任务执行服务器对应调度配置
     */
    @PostMapping("/dispatch/config/create")
    fun create(
        @RequestBody request: ReplicaNodeDispatchConfigCreateRequest
    ): Response<Void> {
        replicaNodeDispatchService.createReplicaNodeDispatchConfig(request)
        return ResponseBuilder.success()
    }

    /**
     * 更新分发任务执行服务器对应调度配置
     */
    @PostMapping("/dispatch/config/update")
    fun update(
        @RequestBody request: ReplicaNodeDispatchConfigUpdateRequest
    ): Response<Void> {
        replicaNodeDispatchService.updateReplicaNodeDispatchConfig(request)
        return ResponseBuilder.success()
    }

    /**
     * 删除分发任务执行服务器对应调度配置
     */
    @DeleteMapping("/dispatch/config/delete/{id}")
    fun delete(
        @PathVariable id: String
    ): Response<Void> {
        replicaNodeDispatchService.deleteReplicaNodeDispatchConfig(id)
        return ResponseBuilder.success()
    }

    /**
     * 获取所有分发任务执行服务器对应调度配置
     */
    @GetMapping("/dispatch/config/list")
    fun list(): Response<List<ReplicaNodeDispatchConfigInfo>> {
        return ResponseBuilder.success(replicaNodeDispatchService.listAllReplicaNodeDispatchConfig())
    }
}
