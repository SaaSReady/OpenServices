package com.openservices.core.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "account_configs")
data class AccountConfig(
    @Id
    @Column(name = "id", updatable = false)
    var id: Long,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "account_id")
    var account: Account,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "service_id")
    var service: Service,
    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "template_id")
    var configTemplate: ConfigTemplate?,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = null,
    var enabled: Boolean,
    var name: String,
    var value: String,
)
