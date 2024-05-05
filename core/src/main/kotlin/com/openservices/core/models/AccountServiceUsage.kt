package com.openservices.core.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "account_service_usages")
data class AccountServiceUsage(
    @Id
    @Column(name = "id", updatable = false)
    var id: Long,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "account_id")
    var account: Account,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "service_id")
    var service: Service,
    var loggedAt: LocalDateTime = LocalDateTime.now(),
    var value: Long,
    var message: String
)
