CREATE TABLE account_quotas(
    id SERIAL PRIMARY KEY,
    account_id UUID NOT NULL,
    service_id UUID NOT NULL,
    quota_scheduler_id INTEGER DEFAULT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    additional BOOLEAN DEFAULT FALSE,
    value INTEGER NOT NULL,
    CONSTRAINT account_quotas_account_fk FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT account_quotas_service_fk FOREIGN KEY (service_id) REFERENCES services(id),
    CONSTRAINT account_quotas_quota_scheduler_fk FOREIGN KEY (quota_scheduler_id) REFERENCES quota_schedulers(id)
);

CREATE INDEX account_quotas_account_idx ON account_quotas(account_id);
CREATE INDEX account_quotas_service_idx ON account_quotas(service_id);
CREATE INDEX account_quotas_quota_scheduler_idx ON account_quotas(quota_scheduler_id);
CREATE INDEX account_quotas_valid_idx ON account_quotas(enabled, added_at, expires_at);