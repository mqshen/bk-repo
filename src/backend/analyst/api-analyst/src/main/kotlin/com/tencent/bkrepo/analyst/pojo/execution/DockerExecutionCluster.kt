package com.tencent.bkrepo.analyst.pojo.execution

import io.swagger.v3.oas.annotations.media.Schema

@Suppress("LongParameterList", "MagicNumber")
data class DockerExecutionCluster(
    override val name: String,
    @Schema(name = "docker host")
    val host: String = "unix://var/run/docker.sock",
    @Schema(name = "docker api version")
    val version: String = "1.23",
    @Schema(name = "docker api connect timeout")
    val connectTimeout: Int = 5000,
    @Schema(name = "docker api read timeout")
    val readTimeout: Int = 0,
    @Schema(name = "最大可同时执行的任务数量")
    val maxTaskCount: Int = 1
) : ExecutionCluster(name, type) {
    companion object {
        const val type: String = "docker"
    }
}
