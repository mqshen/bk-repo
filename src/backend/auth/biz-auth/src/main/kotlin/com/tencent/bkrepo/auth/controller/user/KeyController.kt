/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
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

package com.tencent.bkrepo.auth.controller.user

import com.tencent.bkrepo.auth.constant.AUTH_API_KEY_PREFIX
import com.tencent.bkrepo.auth.pojo.Key
import com.tencent.bkrepo.auth.service.KeyService
import com.tencent.bkrepo.common.api.pojo.Response
import com.tencent.bkrepo.common.service.util.ResponseBuilder
import io.swagger.v3.oas.annotations.tags.TagOperation
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping(AUTH_API_KEY_PREFIX)
class KeyController(private val keyService: KeyService) {

    @Operation(summary = "新增密钥")
    @PostMapping("/create")
    fun createKey(name: String, key: String): Response<Void> {
        keyService.createKey(name, key)
        return ResponseBuilder.success()
    }

    @Operation(summary = "查询公钥列表")
    @GetMapping("/list")
    fun listKey(): Response<List<Key>> {
        return ResponseBuilder.success(keyService.listKey())
    }

    @Operation(summary = "删除公钥")
    @DeleteMapping("/delete/{id}")
    fun deleteKey(id: String): Response<Void> {
        keyService.deleteKey(id)
        return ResponseBuilder.success()
    }
}
