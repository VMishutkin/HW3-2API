CREATE TABLE users(
                     name VARCHAR(30),
                     age INTEGER CONSTRAINT age_constraint CHECK (age > 0),
                     is_licensed BOOLEAN DEFAULT FALSE,
                     car_id INTEGER REFERENCES car (car_id)
);

CREATE TABLE cars(
                    car_id INTEGER PRIMARY KEY,
                    brand VARCHAR(30),
                    model VARCHAR(30),
                    price NUMERIC CONSTRAINT price_constraint CHECK (price > 0)

);
