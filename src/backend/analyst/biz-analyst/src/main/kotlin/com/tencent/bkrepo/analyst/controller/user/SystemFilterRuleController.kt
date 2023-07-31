/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2023 THL A29 Limited, a Tencent company.  All rights reserved.
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

package com.tencent.bkrepo.analyst.controller.user

import com.tencent.bkrepo.analyst.pojo.Constant.SYSTEM_PROJECT_ID
import com.tencent.bkrepo.analyst.pojo.request.filter.ListFilterRuleRequest
import com.tencent.bkrepo.analyst.pojo.request.filter.UpdateFilterRuleRequest
import com.tencent.bkrepo.analyst.pojo.response.filter.FilterRule
import com.tencent.bkrepo.analyst.service.FilterRuleService
import com.tencent.bkrepo.common.api.constant.DEFAULT_PAGE_NUMBER
import com.tencent.bkrepo.common.api.constant.DEFAULT_PAGE_SIZE
import com.tencent.bkrepo.common.api.pojo.Page
import com.tencent.bkrepo.common.api.pojo.Response
import com.tencent.bkrepo.common.security.permission.Principal
import com.tencent.bkrepo.common.security.permission.PrincipalType
import com.tencent.bkrepo.common.service.util.ResponseBuilder
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.TagOperation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name ="分析结果忽略规则")
@RestController
@RequestMapping("/api/filter/rules")
@Principal(PrincipalType.ADMIN)
class SystemFilterRuleController(private val filterRuleService: FilterRuleService) {
    @Operation(summary = "增加规则")
    @PostMapping
    fun addSystemRule(@RequestBody request: UpdateFilterRuleRequest): Response<FilterRule> {
        return ResponseBuilder.success(filterRuleService.create(request))
    }

    @Operation(summary = "更新规则")
    @PutMapping("/{ruleId}")
    fun updateSystemRule(@RequestBody request: UpdateFilterRuleRequest): Response<FilterRule> {
        return ResponseBuilder.success(filterRuleService.update(request))
    }

    @Operation(summary = "删除规则")
    @DeleteMapping("/{ruleId}")
    fun deleteSystemRule(
        @PathVariable("ruleId") ruleId: String
    ): Response<Void> {
        filterRuleService.delete(ruleId)
        return ResponseBuilder.success()
    }

    @Operation(summary = "分页获取规则")
    @GetMapping
    fun listSystemRules(
        @RequestParam(required = false) pageNumber: Int = DEFAULT_PAGE_NUMBER,
        @RequestParam(required = false) pageSize: Int = DEFAULT_PAGE_SIZE
    ): Response<Page<FilterRule>> {
        val request = ListFilterRuleRequest(
            projectId = SYSTEM_PROJECT_ID,
            planId = null,
            pageNumber,
            pageSize
        )
        return ResponseBuilder.success(filterRuleService.list(request))
    }
}