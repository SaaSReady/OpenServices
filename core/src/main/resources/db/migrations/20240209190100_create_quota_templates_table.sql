CREATE TABLE quota_templates(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150) NOT NULL,
    description TEXT,
    enabled BOOLEAN,
    service_id UUID NOT NULL,
    plan_id UUID DEFAULT NULL,
    value INTEGER,
    CONSTRAINT quota_templates_service_fk FOREIGN KEY (service_id) REFERENCES services(id),
    CONSTRAINT quota_templates_plan_fk FOREIGN KEY (plan_id) REFERENCES plans(id)
);

CREATE INDEX quota_templates_name_idx ON quota_templates(name);
CREATE INDEX quota_templates_enabled_idx ON quota_templates(enabled);
CREATE INDEX quota_templates_service_idx ON quota_templates(service_id);
CREATE INDEX quota_templates_plan_idx ON quota_templates(plan_id);