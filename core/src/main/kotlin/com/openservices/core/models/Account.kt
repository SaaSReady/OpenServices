package com.openservices.core.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @Column(name = "id", updatable = false)
    var id: UUID,
    var name: String,
    var email: String,
    var description: String,
    var enabled: Boolean,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "plan_id")
    var plan: Plan,
    @ManyToMany(mappedBy = "roles")
    var users: Set<User> = setOf()
)
