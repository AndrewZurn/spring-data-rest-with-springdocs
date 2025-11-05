package com.andrewzurn.restdatadocs.config

import com.andrewzurn.restdatadocs.model.User
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class SpringDataRestConfigurer : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(
        config: RepositoryRestConfiguration,
        cors: CorsRegistry
    ) {
        super.configureRepositoryRestConfiguration(config, cors)
        config.exposeIdsFor(User::class.java)
    }

}
