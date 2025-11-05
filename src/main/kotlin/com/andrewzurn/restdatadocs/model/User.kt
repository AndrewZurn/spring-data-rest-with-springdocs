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
) {
    @Id
    @Column(columnDefinition = "uuid", updatable = false)
    @Schema(description = "Unique identifier of the user")
    val id: UUID = UUID.randomUUID()
}
