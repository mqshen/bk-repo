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

package com.tencent.bkrepo.common.analysis.pojo.scanner.arrowhead

import com.fasterxml.jackson.annotation.JsonAlias
import com.tencent.bkrepo.common.analysis.pojo.scanner.utils.normalizedLevel
import com.tencent.bkrepo.common.analysis.pojo.scanner.utils.removeRootDirPath
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

@Schema(name = "CVE信息")
data class CveSecItem(
    @Schema(name = "文件路径")
    @JsonAlias("path")
    val path: String,

    @Schema(name = "组件名")
    @JsonAlias("lib_name")
    var component: String,

    @Schema(name = "库版本")
    @JsonAlias("version")
    val version: String,

    @Schema(name = "库版本列表")
    val versions: MutableSet<String> = HashSet(),

    @Schema(name = "漏洞影响版本")
    @JsonAlias("version_effected")
    val versionEffected: String,

    @Schema(name = "漏洞修复版本")
    @JsonAlias("version_fixed")
    val versionFixed: String,

    @Schema(name = "漏洞名")
    @JsonAlias("name")
    val name: String,

    @Schema(name = "漏洞利用类型")
    @JsonAlias("category")
    val category: String,

    @Schema(name = "漏洞类型")
    @JsonAlias("category_type")
    val categoryType: String,

    @Schema(name = "漏洞描述")
    @JsonAlias("description")
    val description: String,

    @Schema(name = "官方解决方案")
    @JsonAlias("official_solution")
    val officialSolution: String,

    @Schema(name = "解决方案")
    @JsonAlias("defense_solution")
    val defenseSolution: String,

    @Schema(name = "相关链接")
    @JsonAlias("reference")
    val references: List<String>,

    @Schema(name = "漏洞年份")
    @JsonAlias("cve_year")
    val cveYear: String,

    @Schema(name = "poc id")
    @JsonAlias("poc_id")
    val pocId: String,

    @Schema(name = "cve id")
    @JsonAlias("cve_id")
    val cveId: String,

    @Schema(name = "cnvd id")
    @JsonAlias("cnvd_id")
    val cnvdId: String,

    @Schema(name = "cnnvd id")
    @JsonAlias("cnnvd_id")
    val cnnvdId: String,

    @Schema(name = "cwe id")
    @JsonAlias("cwe_id")
    val cweId: String,

    /**
     * CRITICAL,HIGH,MEDIUM,LOW
     */
    @Schema(name = "cvss等级")
    @JsonAlias("cvss_rank")
    val cvssRank: String,

    @Schema(name = "cvss 评分")
    @JsonAlias("cvss")
    val cvss: Double,

    @Schema(name = "cvss V3 漏洞影响评价")
    @JsonAlias("cvss_v3")
    val cvssV3: CvssV3?,

    @Schema(name = "cvss V2 漏洞影响评价")
    @JsonAlias("cvss_v2")
    val cvssV2: CvssV2?
) {
    companion object {

        const val TYPE = "CVE_SEC_ITEM"

        fun normalize(cveSecItem: CveSecItem): CveSecItem {
            val path = removeRootDirPath(cveSecItem.path)
            val cvssRank = normalizedLevel(cveSecItem.cvssRank)
            return cveSecItem.copy(path = path, cvssRank = cvssRank)
        }
    }
}
