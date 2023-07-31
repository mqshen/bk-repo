package com.tencent.bkrepo.nuget.controller

import com.tencent.bkrepo.auth.pojo.enums.PermissionAction
import com.tencent.bkrepo.auth.pojo.enums.ResourceType
import com.tencent.bkrepo.common.api.pojo.Response
import com.tencent.bkrepo.common.security.permission.Permission
import com.tencent.bkrepo.common.service.util.ResponseBuilder
import com.tencent.bkrepo.nuget.artifact.NugetArtifactInfo
import com.tencent.bkrepo.nuget.artifact.NugetArtifactInfo.Companion.NUGET_EXT_DELETE_PACKAGE
import com.tencent.bkrepo.nuget.artifact.NugetArtifactInfo.Companion.NUGET_EXT_DELETE_VERSION
import com.tencent.bkrepo.nuget.artifact.NugetArtifactInfo.Companion.NUGET_EXT_DOMAIN
import com.tencent.bkrepo.nuget.artifact.NugetArtifactInfo.Companion.NUGET_EXT_VERSION_DETAIL
import com.tencent.bkrepo.nuget.pojo.artifact.NugetDeleteArtifactInfo
import com.tencent.bkrepo.nuget.pojo.domain.NugetDomainInfo
import com.tencent.bkrepo.nuget.pojo.user.PackageVersionInfo
import com.tencent.bkrepo.nuget.service.NugetWebService
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.TagOperation
import io.swagger.v3.oas.annotations.tags.TagParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name ="NUGET web页面操作接口")
@RestController
@RequestMapping("/ext")
class NugetWebController(
    private val nugetWebService: NugetWebService
) {
    @Permission(ResourceType.REPO, PermissionAction.DELETE)
    @Operation(summary = "删除仓库下的包")
    @DeleteMapping(NUGET_EXT_DELETE_PACKAGE)
    fun deletePackage(
        @RequestAttribute userId: String,
        artifactInfo: NugetDeleteArtifactInfo,
        @Parameter(name ="包名称", required = true)
        @RequestParam packageKey: String
    ): Response<Void> {
        nugetWebService.deletePackage(userId, artifactInfo)
        return ResponseBuilder.success()
    }

    @Permission(ResourceType.REPO, PermissionAction.DELETE)
    @Operation(summary = "删除仓库下的包版本")
    @DeleteMapping(NUGET_EXT_DELETE_VERSION)
    fun deleteVersion(
        @RequestAttribute userId: String,
        artifactInfo: NugetDeleteArtifactInfo,
        @Parameter(name ="包名称", required = true)
        @RequestParam packageKey: String,
        @Parameter(name ="包版本", required = true)
        @RequestParam version: String
    ): Response<Void> {
        nugetWebService.deleteVersion(userId, artifactInfo)
        return ResponseBuilder.success()
    }

    @Permission(ResourceType.REPO, PermissionAction.READ)
    @Operation(summary = "查询包的版本详情")
    @GetMapping(NUGET_EXT_VERSION_DETAIL)
    fun detailVersion(
        @RequestAttribute
        userId: String,
        artifactInfo: NugetArtifactInfo,
        @Parameter(name ="包唯一Key", required = true)
        @RequestParam packageKey: String,
        @Parameter(name ="包版本", required = true)
        @RequestParam version: String
    ): Response<PackageVersionInfo> {
        return ResponseBuilder.success(nugetWebService.detailVersion(artifactInfo, packageKey, version))
    }

    @Operation(summary = "获取nuget域名地址")
    @GetMapping(NUGET_EXT_DOMAIN)
    fun getRegistryDomain(): Response<NugetDomainInfo> {
        return ResponseBuilder.success(nugetWebService.getRegistryDomain())
    }
}
