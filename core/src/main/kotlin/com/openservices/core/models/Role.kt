package com.openservices.core.models

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role(
    @Id
    @Column(name = "id", updatable = false)
    var id: Long,
    var name: String,
    @ManyToMany(mappedBy = "roles")
    var users: Set<User> = setOf()
)
