package com.andrewzurn.restdatadocs.repository

import com.andrewzurn.restdatadocs.model.QUser
import com.andrewzurn.restdatadocs.model.User
import com.querydsl.core.types.dsl.StringExpression
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer
import org.springframework.data.querydsl.binding.QuerydslBindings
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {
    override fun customize(bindings: QuerydslBindings, root: QUser) {
        bindings.bind(String::class.java).first(StringExpression::containsIgnoreCase)
    }
}
