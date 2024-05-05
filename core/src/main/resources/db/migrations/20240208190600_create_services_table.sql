CREATE TABLE services(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150),
    code VARCHAR(10) DEFAULT NULL,
    description TEXT DEFAULT '',
    enabled BOOLEAN DEFAULT FALSE,
    quota_unity VARCHAR(10),
    UNIQUE(name),
    UNIQUE(code)
);

CREATE INDEX services_name_idx ON services(name);
CREATE INDEX services_code_idx ON services(code);