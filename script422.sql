CREATE TABLE driver (
    id  SERIAL PRIMARY KEY,
    name    varchar (50),
    age     INTEGER,
    license BOOLEAN,
    carId   INTEGER REFERENCES car (id)
);

CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    brand varchar(50),
    model varchar(50),
    price NUMERIC
)
