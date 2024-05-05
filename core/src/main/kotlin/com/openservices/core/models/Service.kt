package com.openservices.core.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "services")
data class Service(
    @Id
    @Column(name = "id", updatable = false)
    var id: UUID,
    var name: String,
    var code: String,
    var description: String,
    var enabled: Boolean,
    var quotaUnity: String
)
