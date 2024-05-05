CREATE TABLE user_accounts(
    user_id UUID NOT NULL,
    account_id UUID NOT NULL,
    CONSTRAINT user_accounts_users_fk FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT user_accounts_accounts_fk FOREIGN KEY (account_id) REFERENCES accounts(id),
    UNIQUE(user_id, account_id)
);