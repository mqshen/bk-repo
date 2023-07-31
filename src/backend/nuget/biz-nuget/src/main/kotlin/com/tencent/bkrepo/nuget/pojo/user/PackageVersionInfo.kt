package com.tencent.bkrepo.nuget.pojo.user

import com.tencent.bkrepo.repository.pojo.metadata.MetadataModel
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.media.SchemaProperty

@Tag(name ="nuget版本详情页")
data class PackageVersionInfo(
    @Schema(name = "基础信息")
    val basic: BasicInfo,
    @Schema(name = "元数据信息")
    val metadata: List<MetadataModel>
)

@Tag(name ="基础信息")
data class BasicInfo(
    @Schema(name = "版本字段")
    val version: String,
    @Schema(name = "完整路径")
    val fullPath: String,
    @Schema(name = "文件大小，单位byte")
    val size: Long,
    @Schema(name = "文件sha256")
    val sha256: String,
    @Schema(name = "文件md5")
    val md5: String,
    @Schema(name = "晋级状态标签")
    val stageTag: List<String>,
    @Schema(name = "所属项目id")
    val projectId: String,
    @Schema(name = "所属仓库名称")
    val repoName: String,
    @Schema(name = "下载次数")
    val downloadCount: Long,
    @Schema(name = "创建者")
    val createdBy: String,
    @Schema(name = "创建时间")
    val createdDate: String,
    @Schema(name = "修改者")
    val lastModifiedBy: String,
    @Schema(name = "修改时间")
    val lastModifiedDate: String
)
