CREATE TABLE config_templates(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    service_id UUID NOT NULL,
    plan_id UUID DEFAULT NULL,
    name VARCHAR(150) NOT NULL,
    description TEXT DEFAULT '',
    value VARCHAR(50) DEFAULT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    CONSTRAINT config_templates_service_fk FOREIGN KEY (service_id) REFERENCES services(id),
    CONSTRAINT config_templates_plan_fk FOREIGN KEY (plan_id) REFERENCES plans(id),
    UNIQUE(name)
);

CREATE INDEX config_templates_service_idx ON config_templates(service_id);
CREATE INDEX config_templates_plan_idx ON config_templates(plan_id);
CREATE INDEX config_templates_name_idx ON config_templates(name);
CREATE INDEX config_templates_enabled_idx ON config_templates(enabled);