-- changeset TheBestPessimist:2022-02-13--10-56-43


-- if i uncomment these, it fails
-- INSERT INTO this_does_not_exist_table (id, name) VALUES (1, 'TheBestPessimist');
-- INSERT INTO this_does_not_exist_table (id, name) VALUES (2, 'Cristi');
-- INSERT INTO this_does_not_exist_table (id, name) VALUES (3, 'Viorel');

CREATE TABLE dummy_table
(
    id   INT
        CONSTRAINT table_name_pk
            PRIMARY KEY,
    name text
);

INSERT INTO dummy_table (id, name) VALUES (1, 'TheBestPessimist');
INSERT INTO dummy_table (id, name) VALUES (2, 'Cristi');
INSERT INTO dummy_table (id, name) VALUES (3, 'Viorel');

-- why doesn't Liquibase fail here?
INSERT INTO this_does_not_exist_table (id, name) VALUES (1, 'TheBestPessimist');
INSERT INTO this_does_not_exist_table (id, name) VALUES (2, 'Cristi');
INSERT INTO this_does_not_exist_table (id, name) VALUES (3, 'Viorel');
