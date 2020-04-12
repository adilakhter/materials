--
-- PostgreSQL port of the MySQL "World" database.
--
-- The sample data used in the world database is Copyright Statistics
-- Finland, http://www.stat.fi/worldinfigures.
--

CREATE TABLE IF NOT EXISTS city (
    id integer NOT NULL,
    name varchar NOT NULL,
    countrycode character(3) NOT NULL,
    district varchar NOT NULL,
    population integer NOT NULL
);

CREATE TABLE IF NOT EXISTS country (
...
