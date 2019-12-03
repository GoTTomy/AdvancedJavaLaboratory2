CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    surrname VARCHAR   NOT NULL,
    username VARCHAR   NOT NULL,
    password VARCHAR   NOT NULL,
    email VARCHAR   NOT NULL,
    dateOfBirth VARCHAR   NOT NULL,
    PRIMARY KEY (id)
);