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

package com.tencent.bkrepo.analyst.component.manager.arrowhead.model

import com.tencent.bkrepo.analyst.component.manager.ResultItem
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.Document

@Document("cve_sec_item")
@CompoundIndexes(
    CompoundIndex(
        name = "credentialsKey_sha256_scanner_idx",
        def = "{'credentialsKey': 1, 'sha256': 1, 'scanner': 1}",
        background = true
    )
)
class TCveSecItem(
    id: String? = null,
    credentialsKey: String?,
    sha256: String,
    scanner: String,
    data: TCveSecItemData
) : ResultItem<TCveSecItemData>(id, credentialsKey, sha256, scanner, data)

data class TCveSecItemData(
    /**
     * 文件路径
     */
    val path: String,
    /**
     * 组件名
     */
    val component: String,
    /**
     * 组件版本
     */
    val versions: Set<String> = emptySet(),
    /**
     * 漏洞id
     */
    val pocId: String = "",
    val cveId: String = "",
    val cweId: String = "",
    val cnnvdId: String = "",
    val cnvdId: String = "",
    /**
     * cvss等级， CRITICAL,HIGH,MEDIUM,LOW
     */
    val cvssRank: String
)
