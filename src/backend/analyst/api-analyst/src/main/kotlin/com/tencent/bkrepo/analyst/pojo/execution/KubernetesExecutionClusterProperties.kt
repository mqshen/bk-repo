package com.tencent.bkrepo.analyst.pojo.execution

import io.swagger.v3.oas.annotations.media.Schema

data class KubernetesExecutionClusterProperties(
    @Schema(name = "命名空间")
    val namespace: String = "default",
    @Schema(name = "k8s api server url")
    val apiServer: String? = null,
    @Schema(name = "用于访问apiServer时进行认证，未配置时取当前环境的~/.kube/config，或者当前部署的service account")
    val token: String? = null,
    @Schema(name = "容器limit mem")
    val limitMem: Long = 32 * GB,
    @Schema(name = "容器 request mem")
    val requestMem: Long = 16 * GB,
    @Schema(name = "会在文件三倍大小与该值之间取大者作为容器request ephemeralStorage")
    val requestStorage: Long = 16 * GB,
    @Schema(name = "容器limit ephemeralStorage")
    val limitStorage: Long = 128 * GB,
    @Schema(name = "容器request cpu")
    val requestCpu: Double = 4.0,
    @Schema(name = "容器limit cpu")
    val limitCpu: Double = 16.0
) {
    companion object {
        const val GB = 1024 * 1024 * 1024L
    }
}
