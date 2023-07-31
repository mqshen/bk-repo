package com.tencent.bkrepo.auth.pojo.user

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(name = "分页用户信息")
data class UserInfo(
    @Schema(name = "用户ID")
    val userId: String,
    @Schema(name = "用户名")
    val name: String,
    @Schema(name = "邮箱")
    val email: String?,
    @Schema(name = "联系电话")
    val phone: String?,
    @Schema(name = "用户名")
    val createdDate: LocalDateTime?,
    @Schema(name = "用户名")
    val locked: Boolean,
    @Schema(name = "是否管理员")
    val admin: Boolean,
    @Schema(name = "是否为虚拟用户")
    val group: Boolean,
    @Schema(name = "关联用户")
    val asstUsers: List<String> = emptyList()
)
