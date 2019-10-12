CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(256),
    password VARCHAR(256),
    enabled  BOOLEAN
);

CREATE TABLE authorities (
    username  VARCHAR(256),
    authority VARCHAR(256)
);
