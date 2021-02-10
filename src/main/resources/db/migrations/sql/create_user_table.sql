CREATE TABLE IF NOT EXISTS accounts (
    id uuid PRIMARY KEY,
    username VARCHAR NOT NULL,
    email VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id uuid PRIMARY KEY,
    name VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    account_id uuid NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts (id) ON DELETE RESTRICT
);
