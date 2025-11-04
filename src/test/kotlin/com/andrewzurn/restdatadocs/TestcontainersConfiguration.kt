package com.andrewzurn.restdatadocs

import com.github.dockerjava.api.model.ExposedPort
import com.github.dockerjava.api.model.PortBinding
import com.github.dockerjava.api.model.Ports
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> {
        val containerPort = 5432
        val localPort = 5432
        return PostgreSQLContainer(DockerImageName.parse("postgres:latest"))
            .withExposedPorts(containerPort)
            .withCreateContainerCmdModifier { cmd ->
                cmd.withHostConfig(
                    cmd
                        .hostConfig!!
                        .withPortBindings(
                            PortBinding(
                                Ports.Binding.bindPort(localPort),
                                ExposedPort(containerPort),
                            ),
                        ),
                )
            }
    }
}
