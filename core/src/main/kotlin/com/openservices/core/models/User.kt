package com.openservices.core.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "id", updatable = false)
    var id: UUID,
    var name: String,
    var email: String,
    var login: String,
    var password: String,
    var enabled: Boolean,
    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: Set<Role> = setOf(),
    @ManyToMany
    @JoinTable(
        name = "user_accounts",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "account_id")]
    )
    var accounts: Set<Account> = setOf()
)
