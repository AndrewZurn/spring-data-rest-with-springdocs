package com.andrewzurn.restdatadocs.handlers

import com.andrewzurn.restdatadocs.model.User
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.HandleBeforeSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
@RepositoryEventHandler
class UserEventHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val restClient: RestClient = RestClient.create()

    @HandleBeforeSave
    @HandleBeforeCreate
    fun handleBeforeSave(user: User) {
        // Some custom logic to get additional information about the user
        logger.info("Before saving user: $user")
        val address =
            restClient
                .get()
                .uri("https://api.testingbot.com/v1/free-tools/random-address?country=us")
                .retrieve()
                .body(object : ParameterizedTypeReference<Map<String, Any>>() {})!!
        user.address = address["address"] as String
    }
}
