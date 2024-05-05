package com.openservices.core.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "config_templates")
data class ConfigTemplate(
    @Id
    @Column(name = "id", updatable = false)
    var id: UUID,
    var name: String,
    var description: String,
    var enabled: Boolean,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "service_id")
    var service: Service,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "plan_id")
    var plan: Plan,
    var value: String
)
