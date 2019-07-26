CREATE SCHEMA test AUTHORIZATION postgres;
SET check_function_bodies = false;
--
-- Structure for table users : 
--
SET search_path = test, pg_catalog;
CREATE TABLE test.users (
    uuid uuid NOT NULL,
    money bigint DEFAULT 0 NOT NULL,
    country varchar NOT NULL,
    json varchar NOT NULL,
    create_date timestamp with time zone NOT NULL,
    update_date timestamp with time zone NOT NULL
)
WITH (oids = false);
--
-- Structure for table activities : 
--
CREATE TABLE test.activities (
    uuid uuid NOT NULL,
    user_uuid uuid NOT NULL,
    activity bigint NOT NULL,
    create_date timestamp(6) with time zone NOT NULL
)
WITH (oids = false);
--
-- Definition for index users_pkey : 
--
ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey
    PRIMARY KEY (uuid);
--
-- Definition for index activities_pkey : 
--
ALTER TABLE ONLY activities
    ADD CONSTRAINT activities_pkey
    PRIMARY KEY (uuid);
--
-- Definition for index activities_users_fk : 
--
ALTER TABLE ONLY activities
    ADD CONSTRAINT activities_users_fk
    FOREIGN KEY (user_uuid) REFERENCES users(uuid);
