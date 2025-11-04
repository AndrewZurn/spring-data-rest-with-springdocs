package com.andrewzurn.restdatadocs.repository

import com.andrewzurn.restdatadocs.model.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>
