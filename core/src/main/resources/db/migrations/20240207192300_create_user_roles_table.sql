CREATE TABLE user_roles(
    user_id UUID NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT user_roles_users_fk FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT user_roles_roles_fk FOREIGN KEY (role_id) REFERENCES roles(id),
    UNIQUE(user_id, role_id)
);