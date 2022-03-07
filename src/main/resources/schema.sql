CREATE TABLE IF NOT EXISTS users (
    id Long,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    PRIMARY KEY (id)
);