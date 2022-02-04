CREATE TABLE IF NOT EXISTS users (
    uuid UUID,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    PRIMARY KEY (uuid)
);