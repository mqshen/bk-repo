package com.tencent.bkrepo.repository.pojo.node.service

import com.tencent.bkrepo.repository.pojo.ServiceRequest
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

/**
 * 节点批量删除请求
 */
@Schema(name = "节点批量删除请求")
class NodesDeleteRequest(
	@Schema(name = "所属项目", required = true)
	val projectId: String,
	@Schema(name = "仓库名称", required = true)
	val repoName: String,
	@Schema(name = "节点完整路径列表", required = true)
	val fullPaths: List<String>,
	@Schema(name = "操作用户", required = true)
	override val operator: String,
	@Schema(name = "是否为文件夹", required = false)
	val isFolder: Boolean ? = false
) : ServiceRequest
