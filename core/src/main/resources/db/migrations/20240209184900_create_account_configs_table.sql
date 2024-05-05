CREATE TABLE account_configs(
    id SERIAL PRIMARY KEY,
    account_id UUID NOT NULL,
    service_id UUID NOT NULL,
    template_id UUID DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enabled BOOLEAN DEFAULT TRUE,
    name VARCHAR(150),
    value VARCHAR(50),
    CONSTRAINT account_configs_account_fk FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT account_configs_service_fk FOREIGN KEY (service_id) REFERENCES services(id),
    CONSTRAINT account_configs_template_fk FOREIGN KEY (template_id) REFERENCES config_templates(id),
    UNIQUE(account_id, service_id, enabled)
);