CREATE TABLE IF NOT EXISTS
CREATE TABLE AppUser(
    id SERIAL  PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL,
    number_of_password INT,
    role ENUM(),
    unlock_password VARCHAR(255),
    token VARCHAR(255),
    );
CREATE TABLE IF NOT EXISTS
CREATE TABLE password(
    id SERIAL  PRIMARY KEY,
    last_updated_at DATETIME(6),


);