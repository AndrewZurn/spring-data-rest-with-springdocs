package com.andrewzurn.restdatadocs

import org.springframework.boot.fromApplication
import org.springframework.boot.with
import org.springframework.context.annotation.Profile

fun main(args: Array<String>) {
    fromApplication<RestdatadocsApplication>()
        .withAdditionalProfiles("test")
        .with(TestcontainersConfiguration::class)
        .run(*args)
}
