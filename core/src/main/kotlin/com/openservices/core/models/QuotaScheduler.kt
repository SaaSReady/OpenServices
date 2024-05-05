package com.openservices.core.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "quota_templates")
data class QuotaScheduler(
    @Id
    @Column(name = "id", updatable = false)
    var id: UUID,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "quota_template_id")
    var quotaTemplate: QuotaTemplate,
    var expirationExpression: String,
    var schedulesExpression: String,
    var enabled: Boolean
)
