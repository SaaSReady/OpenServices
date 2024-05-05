CREATE TABLE plans(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150) NOT NULL,
    description TEXT,
    enabled BOOLEAN DEFAULT FALSE,
    UNIQUE(name)
);

CREATE INDEX plans_enabled_idx ON plans(enabled);