package com.tencent.bkrepo.nuget.pojo.request

import io.swagger.v3.oas.annotations.media.SchemaProperty
import io.swagger.v3.oas.annotations.tags.TagOperation

@Operation(summary = "删除包版本请求")
data class PackageVersionDeleteRequest(
    @Schema(name = "所属项目", required = true)
    val projectId: String,
    @Schema(name = "仓库名称", required = true)
    val repoName: String,
    @Schema(name = "包名称", required = true)
    val name: String,
    @Schema(name = "包的版本", required = true)
    val version: String,
    @Schema(name = "操作用户", required = true)
    val operator: String
)
