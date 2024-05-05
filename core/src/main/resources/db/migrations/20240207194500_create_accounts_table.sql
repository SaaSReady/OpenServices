CREATE TABLE accounts(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150) NOT NULL,
    email VARCHAR(100) NOT NULL,
    description TEXT,
    plan UUID NOT NULL,
    enabled BOOLEAN DEFAULT FALSE,
    UNIQUE(name),
    CONSTRAINT accounts_plan_fk FOREIGN KEY (plan) REFERENCES plans(id)
);

CREATE INDEX accounts_enabled_idx ON accounts(enabled);
CREATE INDEX accounts_plan_idx ON accounts(plan);
