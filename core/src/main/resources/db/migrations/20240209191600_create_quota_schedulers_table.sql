CREATE TABLE quota_schedulers(
    id SERIAL PRIMARY KEY,
    quota_template_id UUID NOT NULL,
    expiration_expression VARCHAR(10) NOT NULL,
    scheduler_expression VARCHAR(10) NOT NULL,
    enabled BOOLEAN DEFAULT FALSE,
    CONSTRAINT quota_schedulers_quota_template_fk FOREIGN KEY (quota_template_id) REFERENCES quota_templates(id)
);

CREATE INDEX quota_template_quota_templates_idx ON quota_schedulers(quota_template_id);
CREATE INDEX quota_template_enabled_idx ON quota_schedulers(enabled);