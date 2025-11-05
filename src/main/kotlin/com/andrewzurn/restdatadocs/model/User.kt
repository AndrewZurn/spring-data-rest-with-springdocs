package com.andrewzurn.restdatadocs.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
@Schema(description = "Represents a user in the system")
data class User(
    @Column(name = "first_name", nullable = false)
    @param:Schema(description = "A first name for the user.")
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    @param:Schema(description = "A last name for the user.")
    val lastName: String,

    @Column(name = "email", nullable = false, unique = true)
    @param:Schema(description = "The email for the user. Must be unique.")
    val email: String,

    @Column("address", nullable = false)
    /*
     We want this to be a nullable field so that it's not mandatory in request bodies, as we'll set it in
     some middleware we've added (see UserEventHandler). However, we still want it documented as a required
     field in responses, so we add required = true to indicate it is always expected in the response.
     See OpenApiConfig for it's removal from request bodies)
     */
    @param:Schema(description = "The address of the user.", required = true)
    var address: String? = null,

    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    @param:Schema(description = "Unique identifier of the user")
    val id: UUID = UUID.randomUUID(),
)
