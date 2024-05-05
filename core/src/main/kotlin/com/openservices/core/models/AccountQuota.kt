package com.openservices.core.models

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "account_quotas")
data class AccountQuota(
    @Id
    @Column(name = "id", updatable = false)
    var id: Long,
    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "quota_scheduler_id")
    var quotaScheduler: QuotaScheduler?,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "account_id")
    var account: Account,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "service_id")
    var service: Service,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    var expiresAt: LocalDateTime = LocalDateTime.now(),
    var enabled: Boolean,
    var additional: Boolean,
    var value: Long
)
