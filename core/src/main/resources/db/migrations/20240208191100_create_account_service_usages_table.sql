CREATE TABLE account_service_usages(
    id SERIAL PRIMARY KEY,
    account_id UUID NOT NULL,
    service_id UUID NOT NULL,
    logged_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    value INT NOT NULL,
    message VARCHAR(150) DEFAULT '',
    CONSTRAINT account_service_usages_account_fk FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT account_service_usages_service_fk FOREIGN KEY (service_id) REFERENCES services(id)
);

CREATE INDEX account_service_usages_logged_at_idx ON account_service_usages(logged_at);
CREATE INDEX account_service_usages_account_idx ON account_service_usages(account_id);
CREATE INDEX account_service_usages_service_idx ON account_service_usages(service_id);

