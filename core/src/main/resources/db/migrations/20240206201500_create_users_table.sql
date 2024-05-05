CREATE TABLE users(
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150),
    email VARCHAR(50) DEFAULT NULL,
    login VARCHAR(15),
    password VARCHAR(150),
    enabled boolean DEFAULT TRUE
);