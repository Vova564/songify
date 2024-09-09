CREATE TABLE song (
    id           BIGSERIAL PRIMARY KEY,
    artist       VARCHAR(255) NOT NULL,
    name         VARCHAR(255) NOT NULL,
    release_date TIMESTAMP WITHOUT TIME ZONE,
    duration     BIGINT,
    language     VARCHAR(255)
);