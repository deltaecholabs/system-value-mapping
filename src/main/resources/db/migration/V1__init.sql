CREATE TABLE system
(
    system_id   SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT NOT NULL
);
ALTER SEQUENCE system_system_id_seq RESTART 1000;

CREATE TABLE field
(
    field_id    SERIAL PRIMARY KEY,
    system_id   INT  NOT NULL,
    name        TEXT NOT NULL,
    description TEXT,
    CONSTRAINT fk_system FOREIGN KEY (system_id) REFERENCES system (system_id)
);
ALTER SEQUENCE field_field_id_seq RESTART 1000;