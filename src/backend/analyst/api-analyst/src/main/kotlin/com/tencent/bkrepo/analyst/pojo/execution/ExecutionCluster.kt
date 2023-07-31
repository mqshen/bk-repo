package com.tencent.bkrepo.analyst.pojo.execution

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.media.SchemaProperty

@Schema(name = "任务执行集群配置")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    Type(value = KubernetesJobExecutionCluster::class, name = KubernetesJobExecutionCluster.type),
    Type(value = KubernetesDeploymentExecutionCluster::class, name = KubernetesDeploymentExecutionCluster.type),
    Type(value = DockerExecutionCluster::class, name = DockerExecutionCluster.type),
)
open class ExecutionCluster(
    @Schema(name = "执行集群名")
    open val name: String,
    @Schema(name = "类型")
    val type: String,
    @Schema(name = "描述")
    val description: String = "",
)
