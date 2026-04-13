-- Flyway Migration: V1__create_user.sql
-- DB: PostgreSQL

CREATE TABLE IF NOT EXISTS tb_user (
    user_id     BIGSERIAL       NOT NULL,
    username    VARCHAR(100)    NOT NULL,
    email       VARCHAR(255)    NOT NULL UNIQUE,
    password    VARCHAR(255)    NOT NULL,
    created_at  TIMESTAMP       NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP       NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_tb_user PRIMARY KEY (user_id)
);

CREATE OR REPLACE FUNCTION set_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_user_updated_at
    BEFORE UPDATE ON tb_user
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();
